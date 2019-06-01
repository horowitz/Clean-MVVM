package com.dhorowitz.store.core.di.products

import android.app.Activity
import com.dhorowitz.store.core.di.IO_SCHEDULER
import com.dhorowitz.store.core.di.MAIN_THREAD_SCHEDULER
import com.dhorowitz.store.data.ProductsRepository
import com.dhorowitz.store.data.ProductsRepositoryImpl
import com.dhorowitz.store.data.StoreApi
import com.dhorowitz.store.domain.ProductsInteractor
import com.dhorowitz.store.domain.ProductsInteractorImpl
import com.dhorowitz.store.core.ProductsMapper
import com.dhorowitz.store.core.ProductsMapperImpl
import com.dhorowitz.store.presentation.ProductsActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import javax.inject.Named

@Module
abstract class ProductsModule {
    @Binds
    internal abstract fun provideActivity(activity: ProductsActivity): Activity

    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun provideMapper(): ProductsMapper =
            ProductsMapperImpl()

        @Provides
        @JvmStatic
        internal fun provideRepository(storeApi: StoreApi): ProductsRepository = ProductsRepositoryImpl(storeApi)

        @Provides
        @JvmStatic
        internal fun provideInteractor(
            productsRepository: ProductsRepository,
            productsMapper: ProductsMapper,
            @Named(IO_SCHEDULER) subscribeOn: Scheduler,
            @Named(MAIN_THREAD_SCHEDULER) observeOn: Scheduler
        ):
                ProductsInteractor = ProductsInteractorImpl(productsRepository, productsMapper, subscribeOn, observeOn)
    }
}
