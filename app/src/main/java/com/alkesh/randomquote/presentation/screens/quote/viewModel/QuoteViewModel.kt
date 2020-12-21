package com.alkesh.randomquote.presentation.screens.quote.viewModel

import androidx.lifecycle.MutableLiveData
import com.alkesh.randomquote.common.base.BaseViewModel
import com.alkesh.randomquote.common.repo.QuoteRepository
import com.alkesh.randomquote.presentation.general.uiModel.UIQuoteModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class QuoteViewModel @Inject constructor(
    private val quoteRepo: QuoteRepository
) : BaseViewModel() {
    val quoteModel = MutableLiveData<UIQuoteModel>()

    fun getRandomCode() {
        isLoading.value = true
        quoteModel.value = null
        coroutineScope.launch {
            val result = quoteRepo.getRandomQuote()
            isLoading.value = false
            quoteModel.value = result
        }
    }
}