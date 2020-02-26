package com.example.quotesapp

import android.app.Application
import com.example.quotesapp.data.db.Database
import com.example.quotesapp.data.db.DatabaseFakeImpl
import com.example.quotesapp.data.db.QuoteDao
import com.example.quotesapp.data.repository.QuoteRepository
import com.example.quotesapp.data.repository.QuoteRepositoryImpl
import com.example.quotesapp.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QuotesApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        bind<Database>() with singleton { DatabaseFakeImpl() }
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository>() with singleton { QuoteRepositoryImpl(instance())}
        bind() from provider { QuotesViewModelFactory(instance()) }
    }
}