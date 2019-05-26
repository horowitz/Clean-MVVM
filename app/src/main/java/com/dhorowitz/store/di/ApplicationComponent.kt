package com.dhorowitz.store.di

import com.dhorowitz.store.StoreApp
import com.dhorowitz.store.di.products.ProductsActivityModule
import com.dhorowitz.store.di.products.ProductsModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        NetworkModule::class,
        ProductsModule::class,
        ProductsActivityModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {
    fun inject(app: StoreApp)
}