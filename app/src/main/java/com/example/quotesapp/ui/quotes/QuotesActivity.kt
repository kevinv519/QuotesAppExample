package com.example.quotesapp.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quotesapp.R
import com.example.quotesapp.data.model.Quote
import kotlinx.android.synthetic.main.activity_quotes.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class QuotesActivity : AppCompatActivity(), KodeinAware {
    override val kodein by closestKodein()
    private val factory: QuotesViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi() {
        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")

                textView_quotes.text = stringBuilder.toString()
            }
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(
                editText_quote.text.toString().trim(),
                editText_author.text.toString().trim()
            )
            viewModel.addQuote(quote)
            editText_author.setText("")
            editText_quote.setText("")
        }
    }
}
