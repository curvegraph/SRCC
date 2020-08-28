package com.sriraghunanthancarcare.customer.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.sriraghunanthancarcare.customer.R
import com.sriraghunanthancarcare.pref
import kotlinx.android.synthetic.main.fragment_phone_verification.*


class PhoneVerificationFragment : Fragment() {
    //----------------------------------------------------------------------------------------------
    private lateinit var phoneAuth: PhoneAuth

    //----------------------------------------------------------------------------------------------
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_phone_verification, container, false)
    }

    //----------------------------------------------------------------------------------------------
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btnSend.setOnClickListener {
            phoneAuthentication()
            //Navigation.findNavController(view).navigate(R.id.phone_to_otp_verification)
        }
    }
    //----------------------------------------------------------------------------------------------

    private fun phoneAuthentication() {
        phoneAuth = PhoneAuth(
            activity as LoginActivity,
            object : PhoneCallbacks(object : PhoneCallbacksListener {
                override fun onVerificationCompleted(credential: PhoneAuthCredential?) {
                    view?.let {
                        Navigation.findNavController(it).navigate(R.id.otp_to_add_vehicle)
                    }
                }

                override fun onVerificationFailed(exception: FirebaseException?) {

                }

                override fun onCodeSent(
                    verificationId: String?,
                    token: PhoneAuthProvider.ForceResendingToken?
                ) {
                    pref.phoneVerificationId = verificationId.toString()
                    pref.phoneVerificationToken = token.toString()
                    view?.let {
                        Navigation.findNavController(it).navigate(R.id.phone_to_otp_verification)
                    }
                }

            }) {
            })
        phoneAuth.phoneNumberVerification(phoneNumber.text.toString())
    }
    //----------------------------------------------------------------------------------------------
}