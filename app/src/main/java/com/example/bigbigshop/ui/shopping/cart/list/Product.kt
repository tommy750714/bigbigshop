package com.example.bigbigshop.ui.shopping.cart.list

var productList = mutableListOf<Product>()

class Product (
    var pic: Int,
    var brand: String,
    var name: String,
    var price: String,
    var oPrice: String,
    var description: String,
    var quantity: Int = 1,
    var isChecked: Boolean = false,
    val id: Int? = productList.size
)