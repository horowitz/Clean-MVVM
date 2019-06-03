package com.dhorowitz.store.presentation.checkout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dhorowitz.store.R
import com.dhorowitz.store.core.extension.observe
import com.dhorowitz.store.core.extension.viewModel
import com.dhorowitz.store.presentation.BaseActivity
import com.dhorowitz.store.presentation.product.ProductViewEntity
import dagger.android.AndroidInjection
import javax.inject.Inject

class CheckoutActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var adapter: CheckoutAdapter

    private lateinit var viewModel: CheckoutViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_products)
        viewModel = viewModel(viewModelFactory) {
            observe(items, ::updateItems)
        }

        initViews()
    }

    private fun initViews() {

    }

    private fun updateItems(items: List<CheckoutViewEntity>?) {

    }

    companion object {
        private const val ITEMS_EXTRA = "ITEMS_EXTRA"

        fun intent(context: Context, items: ArrayList<ProductViewEntity>): Intent {
            val intent = Intent(context, CheckoutActivity::class.java)
            intent.putParcelableArrayListExtra(ITEMS_EXTRA, items)
            return intent
        }
    }
}