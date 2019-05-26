package com.dhorowitz.store.data

import io.reactivex.Single

interface ProductsRepository {
    fun fetchProducts(): Single<List<ProductDto>>
}

class ProductsRepositoryImpl(private val storeApi: StoreApi) : ProductsRepository {
    override fun fetchProducts(): Single<List<ProductDto>> = storeApi.getProducts()
}