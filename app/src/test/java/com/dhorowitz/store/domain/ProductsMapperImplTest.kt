package com.dhorowitz.store.domain

import com.dhorowitz.store.core.ProductsMapperImpl
import com.dhorowitz.store.data.ProductsDto
import com.dhorowitz.store.domain.model.ProductDomainEntity
import com.dhorowitz.store.mock.STORE_MOCK_RESPONSE
import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductsMapperImplTest {
    private val productsMapper = ProductsMapperImpl()
    private val productsDto = Gson().fromJson(STORE_MOCK_RESPONSE, ProductsDto::class.java)

    @Test
    fun `should map products dto's into domain entities`() {
        val expected = listOf(
            ProductDomainEntity("VOUCHER", "Cabify Voucher", 5.0),
            ProductDomainEntity("TSHIRT", "Cabify T-Shirt", 20.0),
            ProductDomainEntity("MUG", "Cabify Coffee Mug", 7.5)
        )

        val actual = productsMapper.mapToDomain(productsDto)

        assertEquals(actual, expected)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should error when products array is missing`(){
        val dto = ProductsDto(null)
        productsMapper.mapToDomain(dto)
    }
}