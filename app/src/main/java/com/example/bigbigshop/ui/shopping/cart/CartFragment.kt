package com.example.bigbigshop.ui.shopping.cart

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bigbigshop.R
import com.example.bigbigshop.databinding.FragmentCartBinding
import com.example.bigbigshop.ui.shopping.cart.list.Product
import com.example.bigbigshop.ui.shopping.cart.list.ProductAdapter
import com.example.bigbigshop.ui.shopping.cart.list.productList

class CartFragment : Fragment() {

    companion object {
        fun newInstance() = CartFragment()
    }

    private var _binding: FragmentCartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    private lateinit var viewModel: CartViewModel

    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val cartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root

        populateProducts()

        binding.cartRecycleview.isNestedScrollingEnabled = false
        binding.cartRecycleview.layoutManager = LinearLayoutManager(activity?.applicationContext)
        productAdapter = ProductAdapter(productList, this)
        binding.cartRecycleview.adapter = productAdapter

        binding.selectAll.setOnClickListener { selectAll() }
        binding.deleteBtn.setOnClickListener {
            productList.removeIf {it.isChecked}
            productAdapter.notifyDataSetChanged()
            productAdapter.notifyItemRangeChanged(0, productList.size)
            binding.selectAll.isChecked = false
            }

        return root
    }

    private fun selectAll () {
        if (binding.selectAll.isChecked) {
            productList.forEach { it.isChecked = true }
        } else {
            productList.forEach { it.isChecked = false }
        }
        productAdapter.notifyDataSetChanged()
        productAdapter.notifyItemRangeChanged(0, productList.size)
    }



    private fun populateProducts() {
        productList.clear()
        val products1 = Product(R.drawable.food, "原味道", "兒童口罩", "HK$244", "HK500",1)
        productList.add(products1)

        val products2 = Product(R.drawable.fresh, "大口仔", "成人口罩", "HK$128", "HK188", 1)
        productList.add(products2)

        val products3 = Product(R.drawable.food, "細口仔", "兒童口罩", "HK$88", "HK123",1)
        productList.add(products3)

        val products4 = Product(R.drawable.fresh, "大口仔", "成人口罩", "HK$128", "HK188", 1)
        productList.add(products4)

        val products5 = Product(R.drawable.food, "細口仔", "兒童口罩", "HK$88", "HK123",1)
        productList.add(products5)

        val products6 = Product(R.drawable.fresh, "大口仔", "成人口罩", "HK$128", "HK188", 1)
        productList.add(products6)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun onClick(product: Product) {
    }

    fun onSelect(id: Int) {

        productList.forEach{
            if(it.id == id) {
                it.isChecked = !it.isChecked
            }
        }
        productAdapter.notifyDataSetChanged()

    }

    fun onDelete(position : Int) {
        productList.removeAt(id)
        productAdapter.notifyItemRemoved(id)
    }






}