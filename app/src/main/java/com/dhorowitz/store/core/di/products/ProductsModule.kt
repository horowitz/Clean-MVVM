package com.dhorowitz.store.core.di.products

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.dhorowitz.store.core.di.IO_SCHEDULER
import com.dhorowitz.store.core.di.MAIN_THREAD_SCHEDULER
import com.dhorowitz.store.core.di.PerActivity
import com.dhorowitz.store.core.di.ViewModelKey
import com.dhorowitz.store.data.ProductsDomainMapper
import com.dhorowitz.store.data.ProductsRepository
import com.dhorowitz.store.data.ProductsRepositoryImpl
import com.dhorowitz.store.data.StoreApi
import com.dhorowitz.store.domain.ProductsInteractor
import com.dhorowitz.store.domain.ProductsInteractorImpl
import com.dhorowitz.store.domain.ProductsPresentationMapper
import com.dhorowitz.store.presentation.product.ProductsActivity
import com.dhorowitz.store.presentation.product.ProductsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.Scheduler
import javax.inject.Named

@Module
abstract class ProductsModule {
    @Binds
    @PerActivity
    internal abstract fun provideActivity(activity: ProductsActivity): Activity

    @Binds
    @IntoMap
    @ViewModelKey(ProductsViewModel::class)
    internal abstract fun productsViewModel(viewModel: ProductsViewModel): ViewModel

    @Module
    companion object {
        @Provides
        @JvmStatic
        @PerActivity
        internal fun providePresentationMapper(): ProductsPresentationMapper =
            ProductsPresentationMapper()

        @Provides
        @JvmStatic
        @PerActivity
        internal fun provideDomainMapper(): ProductsDomainMapper =
            ProductsDomainMapper()

        @Provides
        @JvmStatic
        @PerActivity
        internal fun provideInteractor(
            productsRepository: ProductsRepository,
            productsMapper: ProductsDomainMapper,
            @Named(IO_SCHEDULER) subscribeOn: Scheduler,
            @Named(MAIN_THREAD_SCHEDULER) observeOn: Scheduler
        ):
                ProductsInteractor = ProductsInteractorImpl(productsRepository, productsMapper, subscribeOn, observeOn)
    }
}
