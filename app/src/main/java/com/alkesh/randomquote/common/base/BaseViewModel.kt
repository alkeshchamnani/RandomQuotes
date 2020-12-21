package com.alkesh.randomquote.common.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job


open class BaseViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val showMessage = MutableLiveData<String>()

    private val job = Job()
    val coroutineScope = CoroutineScope(Dispatchers.Main + job)


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}