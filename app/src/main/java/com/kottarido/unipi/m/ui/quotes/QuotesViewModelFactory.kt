package com.kottarido.unipi.m.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kottarido.unipi.m.data.QuoteRepository

// auti H class einai enas viewModel provider o opoios xrisimopoieite gia na empodisoume na epanadimiourgithei
// to ViewModel opote alazei to orientation gt alios tha midenizonte ola ta fields mesa sto View kai tha akironete o
// skopos tou viewModel. Ostoso tin proti fora pou to activity i to fragment tha zitaei ena view model tha to dimiourgei
// kai epidi o viewModelProvider kanei instantiate NewInstanceFactory den mporoume na ftia3oume view models apeuthias
// opote ta dimiourgoume se auto to factory
class QuotesViewModelFactory(private val quoteRepository: QuoteRepository)
    :ViewModelProvider.NewInstanceFactory(){

    // kanei override tin fun create i opoia dimiourgei kai epistrefei ena QuoteViewModel sto opoio
    // pernaei san orisma to QuoteRepository kai to kanei cast se type T autis tis generic function
    // to suppress prospernaei to compilation warnings
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }

}