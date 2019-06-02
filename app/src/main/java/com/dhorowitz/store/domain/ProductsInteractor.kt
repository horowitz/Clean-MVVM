package com.dhorowitz.store.domain

import com.dhorowitz.store.core.di.IO_SCHEDULER
import com.dhorowitz.store.core.di.MAIN_THREAD_SCHEDULER
import com.dhorowitz.store.data.ProductsDomainMapper
import com.dhorowitz.store.data.ProductsRepository
import com.dhorowitz.store.domain.model.ProductDomainEntity
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Named

interface ProductsInteractor {
    fun fetchProducts(): Single<List<ProductDomainEntity>>
}

class ProductsInteractorImpl(
    private val repository: ProductsRepository,
    private val mapper: ProductsDomainMapper,
    @Named(IO_SCHEDULER) private val subscribeOn: Scheduler,
    @Named(MAIN_THREAD_SCHEDULER) private val observeOn: Scheduler
) : ProductsInteractor {

    override fun fetchProducts(): Single<List<ProductDomainEntity>> =
        repository.fetchProducts().map { mapper.mapToDomain(it) }
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
}