package com.dhorowitz.store.presentation.checkout

import androidx.lifecycle.MutableLiveData
import com.dhorowitz.store.core.BaseViewModel
import com.dhorowitz.store.presentation.product.ProductViewEntity
import javax.inject.Inject

class CheckoutViewModel @Inject constructor(
    private val mapper: CheckoutPresentationMapper
) : BaseViewModel() {
    val items: MutableLiveData<List<CheckoutViewEntity>> = MutableLiveData()

    fun initialize(products: List<ProductViewEntity>) {
        items.value = mapper.mapToCheckout(products)
    }
}