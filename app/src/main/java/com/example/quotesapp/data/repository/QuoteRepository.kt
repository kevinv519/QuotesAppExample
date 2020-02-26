package com.example.quotesapp.data.repository

import androidx.lifecycle.LiveData
import com.example.quotesapp.data.model.Quote

interface QuoteRepository {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}