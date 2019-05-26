package com.dhorowitz.store.di

import com.dhorowitz.store.StoreApp
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        NetworkModule::class
    ]
)
interface ApplicationComponent {
    fun inject(app: StoreApp)
}