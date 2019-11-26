package com.kottarido.unipi.m.data

// auti i class tha apotelei to repository to opoio tha einai i moni pigi dedomenon pros to viewModel
// exei privet constructor kai einai singleton. Autos o constructor dexete kai argument
class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao){

    // ftiaxnoume 2 functions mia gia add kai mia gia get quotes
    // oi fun prepei na dilononte prin to companion object
    fun addQuote(quote:Quote){
        // prosthetei to quote sto quoteDao to opoio me tin sira tou to vazei stin quoteList kai sti
        // LiveData List me ta quotes
        quoteDao.addQuote(quote)
    }

    // fun pou epistrefei ola ta quotes apo to quoteDao (den epistrefei mutableLiveData alla LiveData sketo)
    fun getQuotes()= quoteDao.getQutoes()



    // gia na einai singleton ftiaxnoume ena companion object
    companion object{
        // xriazomaste ena property pou na anaferete sto monadiko instance pou iparxei
        // volatile simenei oti oi eggrafes se auto to property tha ginete amesos orates sta ala threats
        // kai einai nullable
        @Volatile private var instance: QuoteRepository? = null

        // epistrefei to instance tou antikimenou kai dexete san orisma to quoteDao
        // synchronized ginete an to instance einai null gia na min xrisimopoieithei tautoxrona apo 2 threads
        // alios kanei return to instance apefthias
        fun getInstance(quoteDao: FakeQuoteDao)=
            instance ?: synchronized(this){
                // 3ana elenxei an to instance einai null kai an nai kalei ton construgtor tou QuoteRepository
                // kai tou pernaei san orisma to qoteDao kai episis kanei to instance iso e to it tou also
                instance ?: QuoteRepository(quoteDao).also { instance = it }
            }
    }
}