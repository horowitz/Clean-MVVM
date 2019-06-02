package com.dhorowitz.store.core.extension

import java.text.NumberFormat
import java.util.*

fun Double.priceFormat(): String = NumberFormat.getCurrencyInstance(Locale("es", "ES")).format(this)