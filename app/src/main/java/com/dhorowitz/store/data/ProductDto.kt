package com.dhorowitz.store.data

import com.google.gson.annotations.SerializedName

data class ProductsDto(@SerializedName("products") val products: List<ProductDto>?)

data class ProductDto(
    @SerializedName("code") val code: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("price") val price: Double?
)