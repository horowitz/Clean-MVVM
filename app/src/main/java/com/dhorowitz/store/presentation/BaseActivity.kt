package com.dhorowitz.store.presentation

import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.dhorowitz.store.R
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity() {

    internal fun notifyWithAction(
        viewContainer: View, @StringRes message: Int = R.string.generic_failure, @StringRes actionText: Int = R.string.retry,
        action: () -> Any
    ) {
        val snackBar = Snackbar.make(viewContainer, message, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction(actionText) { action.invoke() }
        snackBar.setActionTextColor(
            ContextCompat.getColor(
                applicationContext,
                R.color.colorAccent
            )
        )
        snackBar.show()
    }
}