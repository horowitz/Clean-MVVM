package com.dhorowitz.store.presentation.checkout

import android.content.Context
import android.content.Intent
import com.dhorowitz.store.presentation.BaseActivity
import com.dhorowitz.store.presentation.product.ProductViewEntity

class CheckoutActivity : BaseActivity() {
    companion object {
        const val ITEMS_EXTRA = "ITEMS_EXTRA"

        fun intent(context: Context, items: ArrayList<ProductViewEntity>): Intent {
            val intent = Intent(context, CheckoutActivity::class.java)
            intent.putParcelableArrayListExtra(ITEMS_EXTRA, items)
            return intent
        }
    }
}