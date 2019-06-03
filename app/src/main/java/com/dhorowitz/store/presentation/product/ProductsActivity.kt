package com.dhorowitz.store.presentation.product

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.dhorowitz.store.R
import com.dhorowitz.store.core.Navigator
import com.dhorowitz.store.core.extension.failure
import com.dhorowitz.store.core.extension.observe
import com.dhorowitz.store.core.extension.viewModel
import com.dhorowitz.store.presentation.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_products.*
import javax.inject.Inject

class ProductsActivity : BaseActivity() {
    companion object {
        private val TAG = ProductsActivity::class.java.simpleName
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var adapter: ProductsAdapter

    @Inject
    lateinit var navigator: Navigator

    private lateinit var viewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_products)
        viewModel = viewModel(viewModelFactory) {
            observe(products, ::updateProducts)
            failure(failure, ::showError)
        }

        initViews()
        loadProductsList()
    }

    private fun initViews() {
        recyclerView.adapter = adapter
        adapter.clickListener = { productViewEntity -> viewModel.addToCart(productViewEntity) }
        btnCheckout.setOnClickListener { navigator.navigateToCheckout(viewModel.cart.value.orEmpty()) }
    }

    private fun loadProductsList() {
        swipeRefreshLayout.isRefreshing = true
        viewModel.loadProducts()
    }

    private fun showError(failure: Throwable?) {
        swipeRefreshLayout.isRefreshing = false
        Log.e(TAG, "error while fetching products", failure)
        notifyWithAction(root, action = ::loadProductsList)
    }

    private fun updateProducts(products: List<ProductViewEntity>?) {
        swipeRefreshLayout.isRefreshing = false
        adapter.collection = products.orEmpty()
    }
}
