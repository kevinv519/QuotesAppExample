package com.example.quotesapp.data.repository

import com.example.quotesapp.data.db.QuoteDao
import com.example.quotesapp.data.model.Quote

class QuoteRepositoryImpl(private val quoteDao: QuoteDao) : QuoteRepository {
    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes() = quoteDao.getQuotes()
}