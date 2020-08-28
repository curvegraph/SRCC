package com.sriraghunanthancarcare.customer.ui.vehicle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.sriraghunanthancarcare.customer.R
import kotlinx.android.synthetic.main.fragment_add_vehicle.*


class AddVehicleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_vehicle, container, false)

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnSave.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.add_vehicle_to_dashboard)
        }
    }
}