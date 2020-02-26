package com.example.quotesapp.data.db

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Quote

interface QuoteDao {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}