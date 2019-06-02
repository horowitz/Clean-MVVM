package com.dhorowitz.store.core.di.checkout

import android.app.Activity
import com.dhorowitz.store.core.di.ActivityModule
import com.dhorowitz.store.presentation.checkout.CheckoutActivity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Subcomponent(modules = [(CheckoutModule::class)])
interface CheckoutSubComponent : AndroidInjector<CheckoutActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<CheckoutActivity>()
}

@Module(subcomponents = [CheckoutSubComponent::class])
abstract class CheckoutActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(CheckoutActivity::class)
    abstract fun bindCheckoutActivityInjectorFactory(builder: CheckoutSubComponent.Builder): AndroidInjector.Factory<out Activity>
}