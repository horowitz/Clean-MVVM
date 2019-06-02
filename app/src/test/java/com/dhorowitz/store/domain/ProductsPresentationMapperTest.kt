package com.dhorowitz.store.domain

import com.dhorowitz.store.domain.model.ProductDomainEntity
import com.dhorowitz.store.presentation.product.ProductType
import com.dhorowitz.store.presentation.product.ProductViewEntity
import org.junit.Assert
import org.junit.Test

class ProductsPresentationMapperTest {
    private val mapper = ProductsPresentationMapper()

    @Test
    fun `should product domain entities into presentation`() {
        val domainEntities = listOf(
            ProductDomainEntity("VOUCHER", "Cabify Voucher", 5.0),
            ProductDomainEntity("TSHIRT", "Cabify T-Shirt", 20.0),
            ProductDomainEntity("MUG", "Cabify Coffee Mug", 7.5)
        )

        val expected = listOf(
            ProductViewEntity(ProductType.Voucher, "Cabify Voucher", 5.0, "5,00 €"),
            ProductViewEntity(ProductType.TShirt, "Cabify T-Shirt", 20.0, "20,00 €"),
            ProductViewEntity(ProductType.Mug, "Cabify Coffee Mug", 7.5, "7,50 €")
        )

        val actual = mapper.mapToPresentation(domainEntities)

        Assert.assertEquals(actual, expected)
    }
}