package com.dhorowitz.store.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dhorowitz.store.R
import com.dhorowitz.store.core.extension.failure
import com.dhorowitz.store.core.extension.observe
import com.dhorowitz.store.core.extension.viewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class ProductsActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        viewModel = viewModel(viewModelFactory) {
            observe(products, ::updateProducts)
            failure(failure, ::showError)
        }

        viewModel.loadProducts()
    }

    private fun showError(failure: Throwable?) {
        
    }

    private fun updateProducts(products: List<ProductViewEntity>?) {

    }
}
