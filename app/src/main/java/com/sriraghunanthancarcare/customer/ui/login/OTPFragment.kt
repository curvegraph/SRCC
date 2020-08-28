package com.sriraghunanthancarcare.customer.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.sriraghunanthancarcare.customer.R
import com.sriraghunanthancarcare.pref
import kotlinx.android.synthetic.main.fragment_o_t_p.*

class OTPFragment : Fragment() {
    //----------------------------------------------------------------------------------------------
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_o_t_p, container, false)
        view.findViewById<MaterialButton>(R.id.button_verify_otp).setOnClickListener {
            val credential = PhoneAuthProvider.getCredential(pref.phoneVerificationId!!, otpEditText.text.toString())
            signInWithPhoneAuthCredential(credential)
        }
        return view
    }
    //----------------------------------------------------------------------------------------------
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        var auth = FirebaseAuth.getInstance()
        activity?.let {
            auth.signInWithCredential(credential)
                .addOnCompleteListener(it) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.e("otp code ", "signInWithCredential:success")
                        val user = task.result?.user
                        view?.let { it ->
                            Navigation.findNavController(it).navigate(R.id.otp_to_add_vehicle)
                        }
                    } else {
                        // Sign in failed, display a message and update the UI
                        Log.e("otp code ", "signInWithCredential:failure", task.exception)
                        if (task.exception is FirebaseAuthInvalidCredentialsException) {
                            otpEditText.setText("")
                        }
                    }
                }
        }
    }
    //----------------------------------------------------------------------------------------------
}