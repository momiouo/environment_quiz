package com.momiouo.naturequiz.data.billing

import android.app.Activity
import android.content.Context
import android.util.Log
import com.android.billingclient.api.AcknowledgePurchaseParams
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.PendingPurchasesParams
import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.PurchasesUpdatedListener
import com.android.billingclient.api.QueryProductDetailsParams
import com.android.billingclient.api.QueryPurchasesParams
import com.momiouo.naturequiz.data.datasource.datastore.AppSharedPref
import com.momiouo.naturequiz.tools.Const
import dagger.hilt.android.qualifiers.ApplicationContext
import fr.momiouo.naturequiz.BuildConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BillingManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val appSharedPref: AppSharedPref
) : PurchasesUpdatedListener {

    private val _isSubscribed = MutableStateFlow(appSharedPref.isAiProSubscribed())
    val isSubscribed: StateFlow<Boolean> = _isSubscribed.asStateFlow()

    private val _formattedPrice = MutableStateFlow<String?>(null)
    val formattedPrice: StateFlow<String?> = _formattedPrice.asStateFlow()

    private var subscriptionProductDetails: ProductDetails? = null

    private val billingClient: BillingClient = BillingClient.newBuilder(context)
        .setListener(this)
        .enablePendingPurchases(
            PendingPurchasesParams.newBuilder()
                .enableOneTimeProducts()
                .build()
        )
        .build()

    init {
        startBillingConnection()
    }

    fun startBillingConnection() {
        if (billingClient.isReady) {
            querySubscriptionDetails()
            queryActiveSubscriptions()
            return
        }
        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    querySubscriptionDetails()
                    queryActiveSubscriptions()
                } else if (BuildConfig.DEBUG) {
                    Log.d(TAG, "Billing setup finished with code: ${billingResult.responseCode}")
                }
            }

            override fun onBillingServiceDisconnected() {
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "Billing service disconnected")
                }
            }
        })
    }

    private fun querySubscriptionDetails() {
        val productList = listOf(
            QueryProductDetailsParams.Product.newBuilder()
                .setProductId(Const.SUBSCRIPTION_PRODUCT_ID)
                .setProductType(BillingClient.ProductType.SUBS)
                .build()
        )
        val params = QueryProductDetailsParams.newBuilder()
            .setProductList(productList)
            .build()

        billingClient.queryProductDetailsAsync(params) { billingResult, queryProductDetailsResult ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                val details = queryProductDetailsResult.productDetailsList.firstOrNull()
                subscriptionProductDetails = details
                val bestOffer = getBestSubscriptionOffer(details)
                val recurringPhase = bestOffer?.pricingPhases?.pricingPhaseList?.firstOrNull { it.priceAmountMicros > 0 }
                    ?: bestOffer?.pricingPhases?.pricingPhaseList?.firstOrNull()
                val price = recurringPhase?.formattedPrice
                if (price != null) {
                    _formattedPrice.value = price
                }
            } else if (BuildConfig.DEBUG) {
                Log.d(TAG, "queryProductDetailsAsync finished with code: ${billingResult.responseCode} (${billingResult.debugMessage})")
            }
        }
    }

    private fun getBestSubscriptionOffer(details: ProductDetails?): ProductDetails.SubscriptionOfferDetails? {
        val offers = details?.subscriptionOfferDetails ?: return null

        // 1. Filter by basePlanId matching Const.SUBSCRIPTION_BASE_PLAN_ID or common names
        val matchingBasePlanOffers = offers.filter {
            it.basePlanId.equals(Const.SUBSCRIPTION_BASE_PLAN_ID, ignoreCase = true) ||
                it.basePlanId.equals("monthly", ignoreCase = true) ||
                it.basePlanId.equals("monthly-plan", ignoreCase = true)
        }.ifEmpty { offers }

        // 2. Direct match by configured offerId (e.g. "free-trial-7-days")
        val exactOfferMatch = matchingBasePlanOffers.firstOrNull { offer ->
            val offerId = offer.offerId
            offerId != null && (
                offerId.equals(Const.SUBSCRIPTION_OFFER_ID, ignoreCase = true) ||
                    offerId.equals("free-trial-7-days", ignoreCase = true) ||
                    offerId.equals("free-trial-7d", ignoreCase = true) ||
                    offerId.equals("trial-7-days", ignoreCase = true) ||
                    offerId.equals("trial-7d", ignoreCase = true) ||
                    offerId.contains("trial", ignoreCase = true)
            )
        }
        if (exactOfferMatch != null) {
            return exactOfferMatch
        }

        // 3. Prioritize offer that includes a 7-day free trial (phase with priceAmountMicros == 0)
        val freeTrialOffer = matchingBasePlanOffers.firstOrNull { offer ->
            offer.pricingPhases.pricingPhaseList.any { phase ->
                phase.priceAmountMicros == 0L
            }
        }

        return freeTrialOffer ?: matchingBasePlanOffers.firstOrNull() ?: offers.firstOrNull()
    }

    fun queryActiveSubscriptions() {
        if (!billingClient.isReady) return
        val params = QueryPurchasesParams.newBuilder()
            .setProductType(BillingClient.ProductType.SUBS)
            .build()

        billingClient.queryPurchasesAsync(params) { billingResult, purchasesList ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                val hasActiveSub = purchasesList.any { purchase ->
                    purchase.purchaseState == Purchase.PurchaseState.PURCHASED &&
                        purchase.products.contains(Const.SUBSCRIPTION_PRODUCT_ID)
                }
                purchasesList.forEach { purchase ->
                    if (purchase.purchaseState == Purchase.PurchaseState.PURCHASED && !purchase.isAcknowledged) {
                        acknowledgePurchase(purchase)
                    }
                }
                if (hasActiveSub) {
                    setSubscribedState(true)
                }
            }
        }
    }

    fun launchSubscriptionFlow(
        activity: Activity?,
        onStoreProductNotReady: () -> Unit
    ) {
        val details = subscriptionProductDetails
        val bestOffer = getBestSubscriptionOffer(details)
        val offerToken = bestOffer?.offerToken

        if (activity != null && billingClient.isReady && details != null && offerToken != null) {
            val productDetailsParamsList = listOf(
                BillingFlowParams.ProductDetailsParams.newBuilder()
                    .setProductDetails(details)
                    .setOfferToken(offerToken)
                    .build()
            )
            val billingFlowParams = BillingFlowParams.newBuilder()
                .setProductDetailsParamsList(productDetailsParamsList)
                .build()
            val billingResult = billingClient.launchBillingFlow(activity, billingFlowParams)
            if (billingResult.responseCode != BillingClient.BillingResponseCode.OK) {
                if (BuildConfig.DEBUG) {
                    Log.w(TAG, "launchBillingFlow returned: ${billingResult.responseCode} (${billingResult.debugMessage})")
                }
                onStoreProductNotReady()
            }
        } else {
            startBillingConnection()
            onStoreProductNotReady()
        }
    }

    override fun onPurchasesUpdated(
        billingResult: BillingResult,
        purchases: MutableList<Purchase>?
    ) {
        if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && purchases != null) {
            for (purchase in purchases) {
                if (purchase.purchaseState == Purchase.PurchaseState.PURCHASED) {
                    if (!purchase.isAcknowledged) {
                        acknowledgePurchase(purchase)
                    }
                    setSubscribedState(true)
                }
            }
        }
    }

    private fun acknowledgePurchase(purchase: Purchase) {
        val params = AcknowledgePurchaseParams.newBuilder()
            .setPurchaseToken(purchase.purchaseToken)
            .build()
        billingClient.acknowledgePurchase(params) { result ->
            if (BuildConfig.DEBUG) {
                Log.d(TAG, "Acknowledge purchase result: ${result.responseCode}")
            }
        }
    }

    fun setSubscribedState(subscribed: Boolean) {
        appSharedPref.setAiProSubscribed(subscribed)
        _isSubscribed.value = subscribed
    }

    companion object {
        private const val TAG = "BillingManager"
    }
}
