package com.dhorowitz.store.core

import android.app.Activity
import com.dhorowitz.store.presentation.checkout.CheckoutActivity
import com.dhorowitz.store.presentation.product.ProductViewEntity

interface Navigator {
    fun navigateToCheckout(items: List<ProductViewEntity>)

}

class NavigatorImpl(private val activity: Activity) : Navigator {

    override fun navigateToCheckout(items: List<ProductViewEntity>) {
        activity.startActivity(CheckoutActivity.intent(activity, ArrayList(items)))
    }

}