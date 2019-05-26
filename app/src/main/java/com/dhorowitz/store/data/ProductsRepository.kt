package com.dhorowitz.store.data

import io.reactivex.Single

interface ProductsRepository {
    fun fetchProducts(): Single<ProductsDto>
}

class ProductsRepositoryImpl(private val storeApi: StoreApi) : ProductsRepository {
    override fun fetchProducts(): Single<ProductsDto> = storeApi.getProducts()
}