package com.kottarido.unipi.m.data

// auti i class tha kanei store ta data tou kathe quote
data class Quote(val quoteText: String,
                 val author: String) {
    // kanoume override tin toString gia na epistrefei to kathe quote
    override fun toString():String{
        // to dolario edo xrisimopoieite gia na provalei kateuthian mia string metavliti mesa sta ""
        // xwris na to kanoume "mplampla"+x+"moasia" opos tha to kaname stin java
        return "$quoteText-$author"
    }
}