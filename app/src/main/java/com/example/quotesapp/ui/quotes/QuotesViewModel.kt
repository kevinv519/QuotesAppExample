package com.example.quotesapp.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.quotesapp.data.model.Quote
import com.example.quotesapp.data.repository.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}