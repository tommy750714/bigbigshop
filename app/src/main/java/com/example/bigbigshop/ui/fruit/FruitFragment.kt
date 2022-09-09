package com.example.bigbigshop.ui.fruit

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
import com.example.bigbigshop.databinding.FragmentSeafoodBinding
import com.example.bigbigshop.ui.fresh.FreshFragment
import com.example.bigbigshop.ui.seafood.SeafoodFragment
import com.example.bigbigshop.ui.seafood.SeafoodViewModel

class FruitFragment : Fragment() {

    companion object {
        fun newInstance() = FruitFragment()
    }

    private var _binding: FragmentFruitBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: FruitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fruitViewModel = ViewModelProvider(this).get(FruitViewModel::class.java)
        _binding = FragmentFruitBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val backButton : ImageButton = root.findViewById(R.id.back_fresh2)

        backButton.setOnClickListener{
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment_activity_main, FreshFragment())
                addToBackStack(FruitFragment::class.java.name)
            }
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FruitViewModel::class.java)
        // TODO: Use the ViewModel
    }

}