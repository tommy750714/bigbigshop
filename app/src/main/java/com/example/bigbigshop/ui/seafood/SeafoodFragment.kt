package com.example.bigbigshop.ui.seafood

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
import com.example.bigbigshop.databinding.FragmentSeafoodBinding
import com.example.bigbigshop.ui.food.FoodFragment
import com.example.bigbigshop.ui.fresh.FreshFragment
import com.example.bigbigshop.ui.fresh.FreshViewModel

class SeafoodFragment : Fragment() {

    companion object {
        fun newInstance() = SeafoodFragment()
    }

    private var _binding: FragmentSeafoodBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: SeafoodViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val seafoodViewModel = ViewModelProvider(this).get(SeafoodViewModel::class.java)
        _binding = FragmentSeafoodBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val backButton : ImageButton = root.findViewById(R.id.back_fresh)

        backButton.setOnClickListener{
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment_activity_main, FreshFragment())
                addToBackStack(SeafoodFragment::class.java.name)
            }
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SeafoodViewModel::class.java)
        // TODO: Use the ViewModel
    }

}