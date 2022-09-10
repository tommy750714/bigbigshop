package com.example.bigbigshop.ui.shopping

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bigbigshop.ui.shopping.cart.CartFragment
import com.example.bigbigshop.ui.shopping.discount.DiscountFragment

class TabsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int) : FragmentStateAdapter(fm, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                // # Cart Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Cart Fragment")
                val cartFragment = CartFragment()
                cartFragment.arguments = bundle
                return cartFragment
            }
            1 -> {
                // # Discount Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Discount Fragment")
                val discountFragment = DiscountFragment()
                discountFragment.arguments = bundle
                return discountFragment
            }
            else -> return CartFragment()
        }
    }

    override fun getItemCount(): Int {
        return numberOfTabs
    }
}