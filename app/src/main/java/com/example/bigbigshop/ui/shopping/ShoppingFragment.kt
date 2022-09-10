package com.example.bigbigshop.ui.shopping

import android.graphics.Color
import android.graphics.Typeface
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.viewpager2.widget.ViewPager2
import com.example.bigbigshop.R
import com.example.bigbigshop.databinding.FragmentSeafoodBinding
import com.example.bigbigshop.databinding.FragmentShoppingBinding
import com.example.bigbigshop.ui.fresh.FreshFragment
import com.example.bigbigshop.ui.seafood.SeafoodFragment
import com.example.bigbigshop.ui.seafood.SeafoodViewModel
import com.example.bigbigshop.ui.shopping.PickAndPay.PickAndPayFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ShoppingFragment : Fragment() {

    companion object {
        fun newInstance() = ShoppingFragment()
    }
    private var _binding: FragmentShoppingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: ShoppingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val seafoodViewModel = ViewModelProvider(this).get(ShoppingViewModel::class.java)
        _binding = FragmentShoppingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val tabLayout : TabLayout = root.findViewById(R.id.tab_layout)

        tabLayout.setSelectedTabIndicatorColor(Color.WHITE)
        // tabLayout.setBackgroundColor(R.color.white)
        // tabLayout.tabTextColors = ContextCompat.getColorStateList(R.color.orange_bigbigshop)

        // Number Of Tabs
        val numberOfTabs = 2

        // Set Tabs in the center
        //tab_layout.tabGravity = TabLayout.GRAVITY_CENTER

        // Show all Tabs in screen
        tabLayout.tabMode = TabLayout.MODE_FIXED

        // Scroll to see all Tabs
        //tab_layout.tabMode = TabLayout.MODE_SCROLLABLE

        // Set Tab icons next to the text, instead above the text
        tabLayout.isInlineLabel = true

        // Set the ViewPager Adapter
        val adapter = TabsPagerAdapter(getChildFragmentManager(), lifecycle, numberOfTabs)
        val tabsViewpager : ViewPager2 = root.findViewById(R.id.tabs_viewpager)

        tabsViewpager.adapter = adapter

        // Enable Swipe
        tabsViewpager.isUserInputEnabled = true

        // Link the TabLayout and the ViewPager2 together and Set Text & Icons
        TabLayoutMediator(tabLayout, tabsViewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "購物車"
                }
                1 -> {
                    tab.text = "加購優惠"
                }
            }
            // Change color of the icons
            tab.icon?.colorFilter =
                BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                    Color.WHITE,
                    BlendModeCompat.SRC_ATOP
                )
        }.attach()

        fun setCustomTabTitles() {
            val vg = tabLayout.getChildAt(0) as ViewGroup
            val tabsCount = vg.childCount

            for (j in 0 until tabsCount) {
                val vgTab = vg.getChildAt(j) as ViewGroup

                val tabChildCount = vgTab.childCount

                for (i in 0 until tabChildCount) {
                    val tabViewChild = vgTab.getChildAt(i)
                    if (tabViewChild is TextView) {

                        // Change Font and Size
                        tabViewChild.typeface = Typeface.DEFAULT_BOLD
//                    val font = ResourcesCompat.getFont(this, R.font.myFont)
//                    tabViewChild.typeface = font
//                    tabViewChild.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25f)
                    }
                }
            }
        }

        val nextButton : Button = root.findViewById(R.id.button_next)

        nextButton.setOnClickListener{
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.nav_host_fragment_activity_main, PickAndPayFragment())
                addToBackStack(ShoppingFragment::class.java.name)
            }
        }


        return root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShoppingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}