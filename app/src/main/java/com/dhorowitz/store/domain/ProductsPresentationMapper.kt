package com.dhorowitz.store.domain

import com.dhorowitz.store.domain.model.ProductDomainEntity
import com.dhorowitz.store.presentation.product.ProductViewEntity
import java.text.NumberFormat
import java.util.*

class ProductsPresentationMapper {
    fun mapToPresentation(domainEntities: List<ProductDomainEntity>): List<ProductViewEntity> =
        domainEntities.map {
            ProductViewEntity(
                it.code,
                it.name,
                formatPrice(it.price)
            )
        }

    private fun formatPrice(price: Double): String = NumberFormat.getCurrencyInstance(Locale("es", "ES")).format(price)

}