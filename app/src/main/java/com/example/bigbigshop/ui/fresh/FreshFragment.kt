package com.example.bigbigshop.ui.fresh

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.commit
import com.example.bigbigshop.R
import com.example.bigbigshop.databinding.FragmentFreshBinding
import com.example.bigbigshop.ui.food.FoodFragment
import com.example.bigbigshop.ui.fruit.FruitFragment
import com.example.bigbigshop.ui.seafood.SeafoodFragment
import com.example.bigbigshop.ui.vegetable.VegetableFragment

class FreshFragment : Fragment() {

    companion object {
        fun newInstance() = FreshFragment()
    }

    private lateinit var viewModel: FreshViewModel

    private var _binding: FragmentFreshBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val freshViewModel = ViewModelProvider(this).get(FreshViewModel::class.java)
        _binding = FragmentFreshBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val backButton : ImageButton = root.findViewById(R.id.back_fresh2)
        val seafoodButton : ImageButton = root.findViewById(R.id.freshseafood_btn)
        val fruitButton : ImageButton = root.findViewById(R.id.fruit_btn)
        val vegetableButton : ImageButton = root.findViewById(R.id.vegetable_btn)

        backButton.setOnClickListener{
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment_activity_main, FoodFragment())
                addToBackStack(FreshFragment::class.java.name)
            }
        }

        seafoodButton.setOnClickListener{
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment_activity_main, SeafoodFragment())
                addToBackStack(FreshFragment::class.java.name)
            }
        }

        fruitButton.setOnClickListener{
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment_activity_main, FruitFragment())
                addToBackStack(FreshFragment::class.java.name)
            }
        }

        vegetableButton.setOnClickListener{
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment_activity_main, VegetableFragment())
                addToBackStack(FreshFragment::class.java.name)
            }
        }
        return root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FreshViewModel::class.java)
        // TODO: Use the ViewModel
    }

}