package com.example.bigbigshop.ui.shopping.cart.list

import android.icu.text.Transliterator

interface ProductClickListener {
    fun onClick(product: Product)
    fun onSelect(position: Int)
}