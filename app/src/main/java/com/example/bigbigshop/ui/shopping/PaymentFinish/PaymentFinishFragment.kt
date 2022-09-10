package com.example.bigbigshop.ui.shopping.PaymentFinish

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
import com.example.bigbigshop.databinding.FragmentPaymentFinishBinding
import com.example.bigbigshop.databinding.FragmentPickAndPayBinding
import com.example.bigbigshop.ui.account.AccountFragment
import com.example.bigbigshop.ui.shopping.PickAndPay.PickAndPayFragment
import com.example.bigbigshop.ui.shopping.PickAndPay.PickAndPayViewModel
import com.example.bigbigshop.ui.shopping.ShoppingFragment

class PaymentFinishFragment : Fragment() {

    companion object {
        fun newInstance() = PaymentFinishFragment()
    }

    private var _binding: FragmentPaymentFinishBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: PaymentFinishViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val seafoodViewModel = ViewModelProvider(this).get(PaymentFinishViewModel::class.java)
        _binding = FragmentPaymentFinishBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val finishButton : Button = root.findViewById(R.id.button_finish)

        finishButton.setOnClickListener{
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment_activity_main, ShoppingFragment())
                addToBackStack(PaymentFinishFragment::class.java.name)
            }
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PaymentFinishViewModel::class.java)
        // TODO: Use the ViewModel
    }

}