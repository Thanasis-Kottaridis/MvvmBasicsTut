package com.kottarido.unipi.m.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

// se auti tin class tha exoume enan fake database table

class FakeQuoteDao {
    // i parenthesi simeni oti kanoume instantiate to antikimeno ekini tin stigmi
    // H mutableList einai mia lista stixion pou epitrepei na prosthetoume kai na aferoume stixia
    // i diafora tis mutable List me tin Array list einai oti den prosdiorizeis ti list thelei na einai
    // praktika i kotlin auti tin stigmi tin mutableList tin metatrepeis se ArrayList
    private val quoteList = mutableListOf<Quote>()
    // H mutableLiveData einai apo to achitecture component library kai ta liveData paratiroun gia alages
    // einai mutable gt theloume na ala3oume tin value ton liveData apo auti tin fake class
    private val quotes = MutableLiveData<List<Quote>>()

    // initializer block
    init{
        // etsi sindeoume apeuthias tin quotes list me ta mutableLiveData ta opoia mporoun na ginoun
        // observed apo tis classes mas
        quotes.value= quoteList
    }

    // method gia add quote
    fun addQuote(quote: Quote){
        // prosthetoume to quote stin list
        quoteList.add(quote)
        // kai enimeronoume ta quotes tou liveData me tin ananeomeni quotesList
        // otan ginei update i quotes.value tha kanei trigger tou observer apo tis alles classes
        quotes.value=quoteList
    }

    // auto stin kotlin simenei oti epistrefei tin lista me ta quotes LiveData kai oxi san mutableLivrData
    // meta kanoume kai cast ta quotes os LiveData<List<Quote>>
    // epidi den theloume na ala3oume tin timi otu live data ektos tou FakeQuoteDao alla theloume apla na tin paratiroume
    fun getQutoes() = quotes as LiveData<List<Quote>>
}