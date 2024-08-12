package com.momiouo.naturequiz.data.datasource.db

import android.util.Log
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

object MyDatabaseCallback : RoomDatabase.Callback() {
    override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
        super.onDestructiveMigration(db)
        onCreate(db)
    }

    // Called when the database is created for the first time.
    override fun onCreate(db: SupportSQLiteDatabase) {
        Log.d("MyDatabaseCallback", "onCreate() called with: db = $db")
        super.onCreate(db)

        val dbContent = DBContent()
        val dbContentEN = DBContentEN()
        val dbFireDB = DBFireDB()
        val dbFireDBEn = DBFireDBEn()

//        db.execSQL("Insert into user(noAds, progression, nbessailesbases, nbessailesanimaux, nbessaileschiffrescles, nbessailestopnews) VALUES(0,\"\",\"1/1\",\"1/1\",\"1/1\",\"1/1/1\")")

        //Les Question :
        //--------------------------------LES BASES
        dbContent.insertLesBases(db)
        dbContent.insertLesBasesLVL3(db)
        //--------------------------------LES CHIFFRES
        dbContent.insertChiffresCles(db)
        dbContent.insertChiffreClesLVL3(db)
        //--------------------------------LES ANIMAUX
        dbContent.insertAnimaux(db)
        dbContent.insertAnimauxLVL3(db)
        //---------------------------------Les Top news
        dbContent.insertTopNews(db)
        dbContent.insertTopNewsLVL3(db)
        //--------------------------------LES DECHETS ET LA DECOMPOSITION que en FR pour l'instant et pas utilisé dans les modes solos
        dbContent.insertDechetsEtDecompo(db)


        //En anglais
        dbContentEN.insertTopNews(db)
        dbContentEN.insertTopNewsLVL3(db)
        dbContentEN.insertDonneesCles(db)
        dbContentEN.insertLesAnimaux(db)
        dbContentEN.insertLesBases(db)
        //LVL3 BASES/ANIMAUX/KEYDATA
        dbContentEN.insertAnimauxLVL3(db)
        dbContentEN.insertChiffreClesLVL3(db)
        dbContentEN.insertLesBasesLVL3(db)

        //FireDB OLD themes now in local db :
        /**Insertion des themes sur datacenter et crypto-monnaie */
        dbFireDB.insertDecentralisation(db)
        dbFireDBEn.insertDecentralisation(db)
        /**Insertion des themes sur le tri et la décomposition */
        dbFireDB.insertTriAndDecomposition(db)
        dbFireDBEn.insertTriAndDecomposition(db)
        /**Insertion des themes sur le changement climatique */
        dbFireDB.insertClimateChange(db)
        dbFireDBEn.insertClimateChange(db)
    }
}