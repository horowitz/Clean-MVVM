package com.dhorowitz.store.domain

import com.dhorowitz.store.data.ProductsDto
import com.dhorowitz.store.data.ProductDto
import com.dhorowitz.store.domain.model.ProductDomainEntity

interface ProductsMapper {
    fun mapToDomain(producstDto: ProductsDto): List<ProductDomainEntity>
}

class ProductsMapperImpl : ProductsMapper {

    override fun mapToDomain(producstDto: ProductsDto): List<ProductDomainEntity> {
        val products = requireNotNull(producstDto.products, { "products are required" })

        return products.map { productDto -> mapToProduct(productDto) }
    }

    private fun mapToProduct(productDto: ProductDto): ProductDomainEntity = ProductDomainEntity(
        requireNotNull(productDto.code),
        requireNotNull(productDto.name),
        requireNotNull(productDto.price)
    )

}