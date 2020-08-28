package com.sriraghunanthancarcare.customer.ui.login

import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import java.util.*
import java.util.concurrent.TimeUnit

//https://firebase.google.com/docs/auth/android/phone-auth
//https://github.com/may-andro/firebase-phone-verification-for-android
//https://codingshiksha.com/blogs/android/firebase-phone-authentication-in-android-full-tutorial
class PhoneAuth(private var activity: LoginActivity, private var callbacks: PhoneCallbacks) {
    //----------------------------------------------------------------------------------------------
    init {
        FirebaseApp.initializeApp(activity)
        var auth = FirebaseAuth.getInstance()
        auth.setLanguageCode(Locale.getDefault().language)

    }

    //----------------------------------------------------------------------------------------------
    fun phoneNumberVerification(phoneNumber: String) {
        PhoneAuthProvider.getInstance()
            .verifyPhoneNumber("+91$phoneNumber", 60L, TimeUnit.SECONDS, activity, callbacks)
    }
    //----------------------------------------------------------------------------------------------
}