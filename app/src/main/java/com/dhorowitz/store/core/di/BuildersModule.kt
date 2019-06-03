package com.dhorowitz.store.core.di

import android.app.Activity
import com.dhorowitz.store.core.di.checkout.CheckoutSubComponent
import com.dhorowitz.store.core.di.products.ProductsSubComponent
import com.dhorowitz.store.presentation.checkout.CheckoutActivity
import com.dhorowitz.store.presentation.product.ProductsActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class BuildersModule {
    @Binds
    @IntoMap
    @ActivityKey(ProductsActivity::class)
    abstract fun bindProductsActivityInjectorFactory(builder: ProductsSubComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(CheckoutActivity::class)
    abstract fun bindCheckoutActivityInjectorFactory(builder: CheckoutSubComponent.Builder): AndroidInjector.Factory<out Activity>
}