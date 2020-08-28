package com.sriraghunanthancarcare.customer.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.sriraghunanthancarcare.customer.R

class LoginActivity : AppCompatActivity() {


    //private lateinit var phoneAuth: PhoneAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        /*phoneAuth = PhoneAuth(this, object : PhoneCallbacks(object : PhoneCallbacksListener {
            override fun onVerificationCompleted(credential: PhoneAuthCredential?) {

            }

            override fun onVerificationFailed(exception: FirebaseException?) {

            }

            override fun onCodeSent(
                verificationId: String?,
                token: PhoneAuthProvider.ForceResendingToken?
            ) {

            }

        }) {

        })*/

    }


}