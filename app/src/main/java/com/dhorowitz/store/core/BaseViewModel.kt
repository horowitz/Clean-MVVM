package com.dhorowitz.store.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    var disposable: Disposable? = null

    private val failure: MutableLiveData<Throwable> = MutableLiveData()

    protected fun handleFailure(failure: Throwable) {
        this.failure.value = failure
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}