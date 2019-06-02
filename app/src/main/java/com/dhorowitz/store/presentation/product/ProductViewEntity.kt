package com.dhorowitz.store.presentation.product

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductViewEntity(val code: String, val name: String, val formattedPrice: String) : Parcelable