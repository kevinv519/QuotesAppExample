package com.example.quotesapp.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.quotesapp.R
import com.example.quotesapp.data.model.Quote
import kotlinx.android.synthetic.main.activity_quotes.*
import org.koin.android.viewmodel.ext.android.viewModel

class QuotesActivity : AppCompatActivity() {
    val viewModel: QuotesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi() {
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
