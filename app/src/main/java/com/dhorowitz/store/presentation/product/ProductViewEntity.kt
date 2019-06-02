package com.dhorowitz.store.presentation.product

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

const val DISCOUNT_FACTOR = 0.24

@Parcelize
data class ProductViewEntity(
    val code: ProductType,
    val name: String,
    val price: Double,
    val formattedPrice: String
) : Parcelable

sealed class ProductType : Parcelable {
    @Parcelize
    object Voucher : ProductType()

    @Parcelize
    object TShirt : ProductType()

    @Parcelize
    object Mug : ProductType()

    @Parcelize
    object Unknown: ProductType()
}