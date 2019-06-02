package com.dhorowitz.store.presentation.checkout

import com.dhorowitz.store.core.extension.priceFormat
import com.dhorowitz.store.presentation.product.DISCOUNT_FACTOR
import com.dhorowitz.store.presentation.product.ProductType
import com.dhorowitz.store.presentation.product.ProductType.TShirt
import com.dhorowitz.store.presentation.product.ProductType.Voucher
import com.dhorowitz.store.presentation.product.ProductViewEntity
import kotlin.math.floor

open class CheckoutPresentationMapper {
    open fun mapToCheckout(products: List<ProductViewEntity>): List<CheckoutViewEntity> = products
        .groupBy { it.name }
        .entries.map(::createCheckoutItem)

    private fun createCheckoutItem(entry: Map.Entry<String, List<ProductViewEntity>>): CheckoutViewEntity {
        val products = entry.value
        val first = products.first()
        val totalPrice = products.size * first.price
        val discountedTotalPrice = calculateDiscount(first.code, first.price, products.size, totalPrice)
        return CheckoutViewEntity(
            products,
            totalPrice,
            discountedTotalPrice,
            totalPrice.priceFormat(),
            discountedTotalPrice?.priceFormat())
    }

    private fun calculateDiscount(code: ProductType, price: Double, size: Int, totalPrice: Double): Double? {
        return when (code) {
            TShirt -> price * size * DISCOUNT_FACTOR
            Voucher -> if (size > 2) totalPrice - calculateVoucherDiscount(price, size) else 0.00
            else -> 0.0
        }
    }

    private fun calculateVoucherDiscount(price: Double, size: Int): Double = price * floor(size / 2.0)
}
