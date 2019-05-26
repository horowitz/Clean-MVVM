package com.dhorowitz.store.domain

import com.dhorowitz.store.data.ProductsRepository
import com.dhorowitz.store.domain.model.ProductDomainEntity
import io.reactivex.Single

interface ProductsInteractor {
    fun fetchProducts(): Single<List<ProductDomainEntity>>
}

class ProductsInteractorImpl(private val repository: ProductsRepository,
                             private val mapper: ProductsMapper): ProductsInteractor {

    override fun fetchProducts(): Single<List<ProductDomainEntity>> =
        repository.fetchProducts().map { mapper.mapToDomain(it) }

}