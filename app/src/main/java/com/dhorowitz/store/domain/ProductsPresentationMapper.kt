package com.dhorowitz.store.domain

import com.dhorowitz.store.core.extension.priceFormat
import com.dhorowitz.store.domain.model.ProductDomainEntity
import com.dhorowitz.store.presentation.product.ProductType
import com.dhorowitz.store.presentation.product.ProductType.*
import com.dhorowitz.store.presentation.product.ProductViewEntity
import java.text.NumberFormat
import java.util.*

open class ProductsPresentationMapper {
    open fun mapToPresentation(domainEntities: List<ProductDomainEntity>): List<ProductViewEntity> =
        domainEntities.map {
            ProductViewEntity(
                codeToType(it.code),
                it.name,
                it.price,
                it.price.priceFormat()
            )
        }

    private fun codeToType(code: String): ProductType = when (code.toLowerCase()) {
        "voucher" -> Voucher
        "tshirt" -> TShirt
        "mug" -> Mug
        else -> Unknown
    }


}