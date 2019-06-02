package com.dhorowitz.store.data

import com.dhorowitz.store.domain.model.ProductDomainEntity
import com.dhorowitz.store.presentation.product.ProductViewEntity
import java.text.NumberFormat
import java.util.*


const val PRODUCTS_REQUIRED_ERROR = "products are required"

class ProductsDomainMapper{
    fun mapToPresentation(domainEntities: List<ProductDomainEntity>): List<ProductViewEntity> =
        domainEntities.map {
            ProductViewEntity(
                it.code,
                it.name,
                formatPrice(it.price)
            )
        }

    fun mapToDomain(producstDto: ProductsDto): List<ProductDomainEntity> {
        val products = requireNotNull(producstDto.products, { PRODUCTS_REQUIRED_ERROR })

        return products.map { productDto -> mapToProduct(productDto) }
    }

    private fun formatPrice(price: Double): String = NumberFormat.getCurrencyInstance(Locale("es", "ES")).format(price)

    private fun mapToProduct(productDto: ProductDto): ProductDomainEntity = ProductDomainEntity(
        requireNotNull(productDto.code),
        requireNotNull(productDto.name),
        requireNotNull(productDto.price)
    )
}