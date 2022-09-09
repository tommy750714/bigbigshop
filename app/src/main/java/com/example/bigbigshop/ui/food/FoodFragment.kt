package com.example.bigbigshop.ui.food

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toolbar
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.commit
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.bigbigshop.R
import com.example.bigbigshop.databinding.FragmentFoodBinding
import com.example.bigbigshop.ui.dashboard.DashboardFragment
import com.example.bigbigshop.ui.fresh.FreshFragment


class FoodFragment : Fragment(){

    companion object {
        fun newInstance() = FoodFragment()
    }

    private lateinit var viewModel: FoodViewModel


    private var _binding: FragmentFoodBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)
        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val freshButton : ImageButton = root.findViewById(R.id.fresh_btn)
        val backButton : ImageButton = root.findViewById(R.id.back_dashboard)

        backButton.setOnClickListener{
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment_activity_main, DashboardFragment())
                addToBackStack(FoodFragment::class.java.name)
            }
        }
        freshButton.setOnClickListener{
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment_activity_main, FreshFragment())
                addToBackStack(FoodFragment::class.java.name)
            }
        }
        return root

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

        // TODO: Use the ViewModel
    }

}