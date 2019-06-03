package com.dhorowitz.store.core.di.products

import com.dhorowitz.store.core.di.ActivityModule
import com.dhorowitz.store.core.di.PerActivity
import com.dhorowitz.store.presentation.product.ProductsActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerActivity
@Subcomponent(modules = [(ActivityModule::class), (ProductsModule::class)])
interface ProductsSubComponent : AndroidInjector<ProductsActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ProductsActivity>()
}