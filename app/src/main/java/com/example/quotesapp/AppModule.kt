package com.example.quotesapp

import com.example.quotesapp.data.db.Database
import com.example.quotesapp.data.db.DatabaseFakeImpl
import com.example.quotesapp.data.db.QuoteDao
import com.example.quotesapp.data.repository.QuoteRepository
import com.example.quotesapp.data.repository.QuoteRepositoryImpl
import com.example.quotesapp.ui.quotes.QuotesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val appModule = module {
    single<Database> { DatabaseFakeImpl() }
    single { get<Database>().quoteDao }
    single<QuoteRepository> { QuoteRepositoryImpl(get()) }
    viewModel { QuotesViewModel(get()) }
}