package com.dhorowitz.store.core.di.checkout

import android.app.Activity
import com.dhorowitz.store.core.di.IO_SCHEDULER
import com.dhorowitz.store.core.di.MAIN_THREAD_SCHEDULER
import com.dhorowitz.store.data.ProductsDomainMapper
import com.dhorowitz.store.data.ProductsRepository
import com.dhorowitz.store.data.ProductsRepositoryImpl
import com.dhorowitz.store.data.StoreApi
import com.dhorowitz.store.domain.ProductsInteractor
import com.dhorowitz.store.domain.ProductsInteractorImpl
import com.dhorowitz.store.domain.ProductsPresentationMapper
import com.dhorowitz.store.presentation.checkout.CheckoutActivity
import com.dhorowitz.store.presentation.product.ProductsActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import javax.inject.Named

@Module
abstract class CheckoutModule {
    @Binds
    internal abstract fun provideActivity(activity: CheckoutActivity): Activity

    @Module
    companion object {

    }
}
