package com.kottarido.unipi.m.utilities

import com.kottarido.unipi.m.data.FakeDatabase
import com.kottarido.unipi.m.data.FakeQuoteDao
import com.kottarido.unipi.m.data.QuoteRepository
import com.kottarido.unipi.m.ui.quotes.QuotesViewModel
import com.kottarido.unipi.m.ui.quotes.QuotesViewModelFactory

// auti i class einai ena singleton to opoio den apeti tipota ston constructor tou
// auto xrisimopoite prokimenou na sigkentrosoume oles tis dependencies gia to quoteViewModel Factory
// se ena meros prokimenou na mporoume eukola na alla3oume ta data i otidipote alo theloume se megalitera projects
// auto legete dependency injection
object InjectorUtils {
    // auto to object tha exei mia monadiki function i opoia parexei ta quotes sto viewModel Factory
    // kai tha kalite apo tin quote activity
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{
        // kanoume instantiate ena quoteRepository kalontas tin getInstance afou einai singleton
        // to opoio xriazete QuoteDao san orisma opote dimiourgoume me ton idio tropo kai ta FakeQuoteDao
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInsance().qoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}