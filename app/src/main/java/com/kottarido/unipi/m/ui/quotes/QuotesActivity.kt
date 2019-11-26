package com.kottarido.unipi.m.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kottarido.unipi.m.R
import com.kottarido.unipi.m.data.Quote
import com.kottarido.unipi.m.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

// apotelei to view Part tou MVVM montelou mas
// ta view provaloun mono to UI kai xirizonte ta Input apo ton xristi
// i diaxirisi ton data ginete meso tou viewModel. To View mporei mono na kalei functions
// tou ViewModel gia na diaxirizete ta Data. Etsi ta data den kanoun reset otan alazei to orientation
// auto ginete gt ta data einai bound me to lifeCycle tou ViewModel kai oxi tou View
class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initialiseUi()
    }

    // ftiaxnoume mia func pou arxikopoiei to UI mesa se auti tin fun
    // tha paroume to viewModelFactory apo to injector utils
    private fun initialiseUi(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        // edo pernoume to viewModel gia to quoteActivity mas
        // to opoio to pernoume apo to viewModelProvider pernontas san orisma to activity(this)
        // kai to factory to opoio paragei to viewModel
        // praktika zitame apo ton Provider na mas parexei me ena paron quoteViewModel i na mas
        // kanei instantiate ena an den iparxi
        val viewModel =ViewModelProviders.of(this,factory)
            .get(QuotesViewModel::class.java)// edo leme ti theloume na mas ftia3ei o provider(QuoteViewModel)

        // edo tha paratiroume (observe) ta live data apo to quotes viewModel pou dimiourgisame i diavasae parapano
        // kai paratiroume oso iparxei o owner (diladi auto to activity this)
        // o observer kathe fora pou finete mia enimerosi pernei mia quoteList kai kanei ta parakato
        viewModel.getQuotes().observe(this, Observer { quotes ->
            // ftiaxnoume ena string builder instance
            val sb = StringBuilder()
            // kai stin sinexia gia kathe quote kanoume append to periexomeno tou ston SB
            quotes.forEach{quote -> sb.append("$quote\n\n")
            }
            // kanei to text tou textView iso me ton SB
            textView_quotes.text = sb.toString()
        })

        // ftiaxnoume to event gia to addQuote button pou iparxei sto activity
        button_add_quote.setOnClickListener {
            // diavazei to kenourio quote apo ta edit text
            val newQuote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            // kai meta pame sto viewModel pou ftia3ame kai kanoume addQuote
            viewModel.addQuotes(newQuote)

            // stin sinexia adiazei to editext ton quotes
            editText_quote.setText("")
            // adiazei to editText gia tous authors
            editText_author.setText("")
        }
    }
}
