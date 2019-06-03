package com.dhorowitz.store.core.di.checkout

import com.dhorowitz.store.core.di.ActivityModule
import com.dhorowitz.store.core.di.PerActivity
import com.dhorowitz.store.presentation.checkout.CheckoutActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerActivity
@Subcomponent(modules = [(ActivityModule::class), (CheckoutModule::class)])
interface CheckoutSubComponent : AndroidInjector<CheckoutActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<CheckoutActivity>()
}