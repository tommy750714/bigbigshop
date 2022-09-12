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
        val products1 = Product(R.drawable.crab_meat, "原味道", "原味道 韓國即食醬油蟹肉 增量150g (最佳賞味期限：2022年10月11號)", "HK$265", "","每罐含2-3隻韓國大花蟹蟹肉及蟹膏精華",1)
        productList.add(products1)

        val products2 = Product(R.drawable.abalone, "原味道", "原味道紅燒鮑魚6隻裝", "HK$208", "","【原味道】每罐6隻，即開即食，口感爽滑，無加防腐劑，好味健康", 1)
        productList.add(products2)

        val products3 = Product(R.drawable.oyster, "榮記", "榮記 流浮山生曬金蠔 300g (半斤裝)", "HK$398", "HK$438","流浮山生蠔曾富盛名，生蠔更成為流浮山地道特產，故此流浮山蠔吸引不少的旅客慕名而來。",1)
        productList.add(products3)

        val products4 = Product(R.drawable.duck_leg, "住家蔡", "蔡市場-生鴨髀 420G", "HK$29.9", "HK$38.9","CHOI-Duck Legs 420G", 1)
        productList.add(products4)

        val products5 = Product(R.drawable.beef, "Gourmet", "澳洲 M7/M8穀飼和牛 - 3包套餐", "HK$468", "HK498","於澳洲牧場培養和繁殖的日本牛種，需跟從日本和牛的飼養規定，所以油花分佈亦不遜於日本和牛。",1)
        productList.add(products5)

        val products6 = Product(R.drawable.chicken, "住家蔡", "蔡市場-去皮雞柳 1000G", "HK$49.9", "HK68.9","CHOI-Chicken Tenderloins (Skinless) 1000G", 1)
        productList.add(products6)

        val products7 = Product(R.drawable.shamp, "住家蔡", "尚蔡-L2級 阿根廷紅蝦, 2KG", "HK$262", "HK$320","Big Big 刺身推介", 1)
        productList.add(products7)
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