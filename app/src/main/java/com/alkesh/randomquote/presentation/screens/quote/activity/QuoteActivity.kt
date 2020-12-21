package com.alkesh.randomquote.presentation.screens.quote.activity

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alkesh.randomquote.R
import com.alkesh.randomquote.common.base.BaseActivity
import com.alkesh.randomquote.common.di.ViewModelProviderFactory
import com.alkesh.randomquote.presentation.general.uiModel.UIQuoteModel
import com.alkesh.randomquote.presentation.screens.quote.viewModel.QuoteViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_quote.*
import javax.inject.Inject

class QuoteActivity : BaseActivity() {
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory


     lateinit var viewModel: QuoteViewModel
    override fun init() {
        AndroidInjection.inject(this)
        viewModel = ViewModelProvider(this, providerFactory).get(QuoteViewModel::class.java)
        viewModel.getRandomCode()
    }

    override fun setEvents() {
        btnFetchNew.setOnClickListener(View.OnClickListener {
            viewModel.getRandomCode()
        })

    }

    override fun setObservers() {
        viewModel.isLoading.observe(this, Observer {
            it?.let {
                if (it) {
                    showLoadingDialog()
                } else {
                    hideLoadingDialog()
                }
            }
        })
        viewModel.showMessage.observe(this, Observer {
            it?.let {
                showMessage(it)
            }
        })
        viewModel.quoteModel.observe(this, Observer {
            it?.let {
                populateData(it)
            }
        })
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_quote
    }

    private fun populateData(uiModel: UIQuoteModel) {
        uiModel.author?.let {
            tvAuthor.text = it
        }
        uiModel.quote?.let {
            tvQuote.text = it
        }
        uiModel.source?.let {
            tvDataSource.text = it
        }
    }
}