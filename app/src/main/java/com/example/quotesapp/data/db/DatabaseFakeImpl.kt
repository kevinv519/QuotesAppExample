package com.example.quotesapp.data.db

class DatabaseFakeImpl : Database {
    override val quoteDao: QuoteDao = QuoteDaoFakeImpl()
}