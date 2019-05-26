package com.dhorowitz.store.di

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Named

const val MAIN_THREAD_SCHEDULER = "main_thread_scheduler"
const val IO_SCHEDULER = "io_scheduler"

@Module
class ApplicationModule {

    @Provides
    @Named(MAIN_THREAD_SCHEDULER)
    fun provideAndroidMainThreadScheduler(): Scheduler = mainThread()

    @Provides
    @Named(IO_SCHEDULER)
    fun provideIoScheduler() = io()
}