package com.dhorowitz.store.core.di.products

import android.app.Activity
import com.dhorowitz.store.core.di.ActivityModule
import com.dhorowitz.store.presentation.ProductsActivity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Subcomponent(modules = [(ActivityModule::class), (ProductsModule::class)])
interface ProductsSubComponent : AndroidInjector<ProductsActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ProductsActivity>()
}

@Module(subcomponents = [ProductsSubComponent::class])
abstract class ProductsActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(ProductsActivity::class)
    abstract fun bindProductsActivityInjectorFactory(builder: ProductsSubComponent.Builder): AndroidInjector.Factory<out Activity>
}