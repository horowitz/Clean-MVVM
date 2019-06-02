package com.dhorowitz.store.presentation.checkout

import com.dhorowitz.store.presentation.product.DISCOUNT_FACTOR
import com.dhorowitz.store.presentation.product.ProductType
import com.dhorowitz.store.presentation.product.ProductType.*
import com.dhorowitz.store.presentation.product.ProductViewEntity
import org.amshove.kluent.shouldEqualTo
import org.junit.Test

class CheckoutPresentationMapperTest {
    private val mapper = CheckoutPresentationMapper()

    @Test
    fun `should apply discount given 3 t-shirts`() {
        val price = 25.0
        val products = List(5) { ProductViewEntity(TShirt, "name", price, "") }
        val expectedPrice = products.size * price * DISCOUNT_FACTOR

        val actual = mapper.mapToCheckout(products).first().discountedTotalPrice

        actual shouldEqualTo expectedPrice
    }

    @Test
    fun `should apply discount given 6 vouchers`() {
        val price = 2.0
        val products = List(6) { ProductViewEntity(Voucher, "name", price, "") }
        val expectedPrice = 6.0

        val actual = mapper.mapToCheckout(products).first().discountedTotalPrice

        actual shouldEqualTo expectedPrice
    }

    @Test
    fun `should apply discount and format price correctly`(){
        val price = 2.0
        val products = List(6) { ProductViewEntity(Voucher, "name", price, "") }
        val expectedFormattedTotalPrice = "12,00 €"
        val expectedFormattedDiscountedTotalPrice = "6,00 €"

        val actual = mapper.mapToCheckout(products).first()

        actual.totalPriceFormatted shouldEqualTo expectedFormattedTotalPrice
        actual.discountedPriceFormatted shouldEqualTo expectedFormattedDiscountedTotalPrice
    }

}