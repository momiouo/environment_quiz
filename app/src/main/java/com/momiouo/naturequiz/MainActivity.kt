package com.momiouo.naturequiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.momiouo.naturequiz.ui.navigation.AppNavHost
import com.momiouo.naturequiz.ui.theme.NatureQuizTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        MobileAds.initialize(this) {}
        MobileAds.setRequestConfiguration(
            //TODO get your hashed device id from logcat output
            RequestConfiguration.Builder().setTestDeviceIds(listOf("34271JEGR08361")).build()
        )
        setContent {
            NatureQuizTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(Modifier.padding(innerPadding)) {
                        AppNavHost()
                    }
                }
            }
        }
    }
}