package com.dhorowitz.store.data

import io.reactivex.Single
import retrofit2.http.GET

interface StoreApi {
    @GET("/bins/4bwec")
    fun getProducts(): Single<ProductsDto>
}