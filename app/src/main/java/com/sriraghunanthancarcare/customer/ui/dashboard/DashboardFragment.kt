package com.sriraghunanthancarcare.customer.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.sriraghunanthancarcare.customer.R
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navigationView.inflateMenu(R.menu.bottom_menu)
        loadFragment(HomeFragment())
        navigationView.setOnNavigationItemSelectedListener { item: MenuItem ->
            return@setOnNavigationItemSelectedListener when (item.itemId) {
                R.id.homeMenuId -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.bookingMenuId -> {
                    loadFragment(BookingFragment())
                    true
                }
                R.id.serviceMenuId -> {
                    loadFragment(ServiceFragment())
                    true
                }
                R.id.profileMenuId -> {
                    loadFragment(ProfileFragment())
                    true
                }
                R.id.supportMenuId -> {
                    loadFragment(SupportFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}