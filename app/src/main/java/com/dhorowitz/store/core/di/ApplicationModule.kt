package com.dhorowitz.store.core.di

import com.dhorowitz.store.core.di.checkout.CheckoutSubComponent
import com.dhorowitz.store.core.di.products.ProductsSubComponent
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Named

const val MAIN_THREAD_SCHEDULER = "main_thread_scheduler"
const val IO_SCHEDULER = "io_scheduler"

@Module(
    subcomponents = [
        (ProductsSubComponent::class),
        (CheckoutSubComponent::class)
    ]
)
class ApplicationModule {
    @Provides
    @Named(MAIN_THREAD_SCHEDULER)
    fun provideAndroidMainThreadScheduler(): Scheduler = mainThread()

    @Provides
    @Named(IO_SCHEDULER)
    fun provideIoScheduler() = io()
}