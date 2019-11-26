package com.kottarido.unipi.m.data

// se ena pragmatiko app tha eprepe na exoume access se perisotera apo enos eidous objects (quotes)
// kai gia na exoume tin prosvasi olon ton data se ena meros tha prepei na ftia3oume mia class opos eixa
// kanei me ton  dataHelper sto speedMeter me SQlite. kai epidi den exei noima na exoume 2 instances tis
// database class tin kanoume singleton me tin kotlin pou to kanei eukola xrisimopiontas to keyword object
// anti gia class

// edo dimiourgoume singleton sto opoio exoume na perasoume kati ston constructor me ton tropo tis java

// kanoume ton constructor privet gia na fenete mono entso class
class FakeDatabase private constructor(){

    // i databese einai enas holder gia ola ta data access objects (DAO)
    // auto to property exei privet set ara mporoume na to kanoume set mono apo tin FakeDatabese class
    var qoteDao = FakeQuoteDao()
        private set

    // me to companion object tha pernoume ta instances tis class
    companion object{
        // xriazomaste ena property pou na anaferete sto monadiko instance pou iparxei
        // volatile simenei oti oi eggrafes se auto to property tha ginete amesos orates sta ala threats
        // kai einai nullable
        @Volatile private var instance: FakeDatabase? = null

        // auti i method tha epistrefei to insance
        // otan mia function exei "=" simenei return. to "?:" simenei den einai null
        // an to instance einai null tha epistrepsei otidipote einai meta to "?:"
        fun getInsance() =
            instance ?: synchronized(this){
                // H also function kalei tin function pou proigite(FakeDatabase()) pernontas to this san argument
                // opou vlepw also ston kodika to diavazw "and also do the following"
                // opou to it einai to antikimeno tou this
                instance?: return FakeDatabase().also { instance = it }
            }
    }
}