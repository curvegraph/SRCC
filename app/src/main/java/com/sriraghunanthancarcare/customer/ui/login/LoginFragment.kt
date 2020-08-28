package com.sriraghunanthancarcare.customer.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import com.sriraghunanthancarcare.customer.R

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.findViewById<MaterialButton>(R.id.phoneAuthentication).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.login_to_phone_verification)
        }
        return view;
    }
}