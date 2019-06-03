package com.dhorowitz.store.core.di.checkout

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.dhorowitz.store.core.di.PerActivity
import com.dhorowitz.store.core.di.ViewModelKey
import com.dhorowitz.store.presentation.checkout.CheckoutActivity
import com.dhorowitz.store.presentation.checkout.CheckoutPresentationMapper
import com.dhorowitz.store.presentation.checkout.CheckoutViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class CheckoutModule {
    @Binds
    @PerActivity
    internal abstract fun provideActivity(activity: CheckoutActivity): Activity

    @Binds
    @IntoMap
    @ViewModelKey(CheckoutViewModel::class)
    internal abstract fun checkoutViewModel(viewModel: CheckoutViewModel): ViewModel

    @Module
    companion object {
        @Provides
        @JvmStatic
        @PerActivity
        internal fun providePresentationMapper(): CheckoutPresentationMapper =
            CheckoutPresentationMapper()
    }


}
