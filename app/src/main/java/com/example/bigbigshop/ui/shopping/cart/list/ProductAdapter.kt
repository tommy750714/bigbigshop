package com.example.bigbigshop.ui.shopping.cart.list

import android.icu.text.Transliterator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bigbigshop.databinding.ProductCellBinding
import com.example.bigbigshop.ui.shopping.cart.CartFragment

class ProductAdapter(
    private val cartProducts: List<Product>,
    private val clickListener: CartFragment

) : RecyclerView.Adapter<ProductViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ProductCellBinding.inflate(from, parent, false)
        return ProductViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindProduct(cartProducts[position])
    }

    override fun getItemCount(): Int = cartProducts.size


}
