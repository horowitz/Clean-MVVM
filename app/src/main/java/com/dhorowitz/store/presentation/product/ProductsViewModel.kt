package com.dhorowitz.store.presentation.product

import androidx.lifecycle.MutableLiveData
import com.dhorowitz.store.core.BaseViewModel
import com.dhorowitz.store.core.extension.add
import com.dhorowitz.store.domain.ProductsInteractor
import com.dhorowitz.store.domain.ProductsPresentationMapper
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ProductsViewModel @Inject constructor(
    private val productsInteractor: ProductsInteractor,
    private val productsMapper: ProductsPresentationMapper
) : BaseViewModel() {

    val products = MutableLiveData<List<ProductViewEntity>>()
    val cart = MutableLiveData<List<ProductViewEntity>>()

    fun loadProducts() {
        disposable =
            productsInteractor.fetchProducts()
                .map { productsMapper.mapToPresentation(it) }
                .subscribeBy(
                    onSuccess = ::handleProductsList,
                    onError = ::handleFailure
                )

    }

    fun addToCart(productViewEntity: ProductViewEntity) {
        cart.add(productViewEntity)
    }

    private fun handleProductsList(products: List<ProductViewEntity>?) {
        this.products.postValue(products)
    }
}