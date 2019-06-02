package com.dhorowitz.store.presentation.checkout

import com.dhorowitz.store.presentation.product.ProductViewEntity

data class CheckoutViewEntity(
    val products: List<ProductViewEntity>,
    val totalPrice: Double,
    val discountedTotalPrice: Double? = null,
    val totalPriceFormatted: String,
    val discountedPriceFormatted: String? = null
)