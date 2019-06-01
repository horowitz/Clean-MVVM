package com.dhorowitz.store.presentation

import androidx.lifecycle.MutableLiveData
import com.dhorowitz.store.core.BaseViewModel
import com.dhorowitz.store.core.ProductsMapper
import com.dhorowitz.store.domain.ProductsInteractor
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ProductsViewModel @Inject constructor(
    private val productsInteractor: ProductsInteractor,
    private val productsMapper: ProductsMapper
) : BaseViewModel() {

    val products = MutableLiveData<List<ProductViewEntity>>()

    fun loadProducts() {
        disposable = productsInteractor.fetchProducts()
            .map { productsMapper.mapToPresentation(it) }
            .subscribeBy(
                onSuccess = { handleProductsList(it) },
                onError = { handleFailure(it) }
            )

    }

    private fun handleProductsList(products: List<ProductViewEntity>?) {
        this.products.postValue(products)
    }

}