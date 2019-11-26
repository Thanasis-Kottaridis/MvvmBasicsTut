package com.kottarido.unipi.m.ui.quotes

import androidx.lifecycle.ViewModel
import com.kottarido.unipi.m.data.Quote
import com.kottarido.unipi.m.data.QuoteRepository

// edo exoume to viewModel tou MVVM montelou mas to opoio dexete san orisma to QuoteRepository
// kai klironomi (inherit tin Class ViewModel)
class QuotesViewModel(private val quoteRepository: QuoteRepository)
    :ViewModel(){

    // edo tha exoume 2 functions 1 gia get quotes kai mia gia add quotes
    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuotes(quote: Quote){
        quoteRepository.addQuote(quote)
    }
}