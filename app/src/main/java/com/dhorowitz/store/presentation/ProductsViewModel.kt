package com.dhorowitz.store.presentation

import androidx.lifecycle.ViewModel
import com.dhorowitz.store.di.IO_SCHEDULER
import com.dhorowitz.store.di.MAIN_THREAD_SCHEDULER
import com.dhorowitz.store.domain.ProductsInteractor
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class ProductsViewModel @Inject constructor(
    private val productsInteractor: ProductsInteractor,
    @Named(IO_SCHEDULER) private val subscribeOn: Scheduler,
    @Named(MAIN_THREAD_SCHEDULER) private val observeOn: Scheduler
) : ViewModel() {

}