package com.example.bigbigshop.ui.shopping.PickAndPay

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.commit
import com.example.bigbigshop.R
import com.example.bigbigshop.databinding.FragmentPickAndPayBinding
import com.example.bigbigshop.databinding.FragmentSeafoodBinding
import com.example.bigbigshop.ui.fresh.FreshFragment
import com.example.bigbigshop.ui.seafood.SeafoodFragment
import com.example.bigbigshop.ui.seafood.SeafoodViewModel
import com.example.bigbigshop.ui.shopping.PaymentFinish.PaymentFinishFragment
import com.example.bigbigshop.ui.shopping.ShoppingFragment

class PickAndPayFragment : Fragment() {

    companion object {
        fun newInstance() = PickAndPayFragment()
    }

    private var _binding: FragmentPickAndPayBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: PickAndPayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val seafoodViewModel = ViewModelProvider(this).get(PickAndPayViewModel::class.java)
        _binding = FragmentPickAndPayBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val payButton : Button = root.findViewById(R.id.button_pay)

        payButton.setOnClickListener{
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment_activity_main, PaymentFinishFragment())
                addToBackStack(PickAndPayFragment::class.java.name)
            }
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PickAndPayViewModel::class.java)
        // TODO: Use the ViewModel
    }

}