package com.example.bigbigshop.ui.vegetable

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.commit
import com.example.bigbigshop.R
import com.example.bigbigshop.databinding.FragmentFruitBinding
import com.example.bigbigshop.databinding.FragmentVegetableBinding
import com.example.bigbigshop.ui.fresh.FreshFragment
import com.example.bigbigshop.ui.fruit.FruitFragment
import com.example.bigbigshop.ui.fruit.FruitViewModel

class VegetableFragment : Fragment() {

    companion object {
        fun newInstance() = VegetableFragment()
    }

    private var _binding: FragmentVegetableBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: VegetableViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fruitViewModel = ViewModelProvider(this).get(VegetableViewModel::class.java)
        _binding = FragmentVegetableBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val backButton : ImageButton = root.findViewById(R.id.back_fresh3)

        backButton.setOnClickListener{
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment_activity_main, FreshFragment())
                addToBackStack(VegetableFragment::class.java.name)
            }
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VegetableViewModel::class.java)
        // TODO: Use the ViewModel
    }

}