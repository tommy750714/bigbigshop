package com.example.bigbigshop.ui.shopping.cart.list
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bigbigshop.databinding.ProductCellBinding
import com.example.bigbigshop.ui.shopping.cart.CartFragment

class ProductViewHolder(

    private val productCellBinding: ProductCellBinding,
    private val clickListener: CartFragment
): RecyclerView.ViewHolder(productCellBinding.root) {
    fun bindProduct(product: Product) {

        productCellBinding.productImage.setImageResource(product.pic)
        productCellBinding.brand.text = product.brand
        productCellBinding.name.text = product.name
        productCellBinding.price.text = product.price
        productCellBinding.oPrice.text = product.oPrice
        productCellBinding.description.text = product.description
        productCellBinding.quantity.text = product.quantity.toString()
        productCellBinding.checkBox.isChecked = product.isChecked

        productCellBinding.checkBox.setOnClickListener {
            product.id?.let { item -> clickListener.onSelect(item) }
        }

        productCellBinding.add.setOnClickListener{
            product.quantity += 1
            productCellBinding.quantity.text = product.quantity.toString()
        }

        productCellBinding.deduct.setOnClickListener{
            product.quantity -= 1
            Log.d(TAG,product.quantity.toString())
            if (product.quantity <= 0) {
                product.quantity += 1
            } else {
                productCellBinding.quantity.text = product.quantity.toString()
            }
        }


    }
}