package com.example.bigbigshop.ui.shopping.discount

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bigbigshop.R

class DiscountFragment : Fragment() {

    companion object {
        fun newInstance() = DiscountFragment()
    }

    private lateinit var viewModel: DiscountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_discount, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DiscountViewModel::class.java)
        // TODO: Use the ViewModel
    }

}