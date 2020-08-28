package com.sriraghunanthancarcare.customer.util

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    private val sharedPreferences = "com.sriraghunanthancarcare.customer.prefs"
    private val registerMobNo = "registered_mob_no"
    private val username = "user_name"
    private val verificationId = "verification_id"
    private val token = "token"

    private val prefs: SharedPreferences = context.getSharedPreferences(sharedPreferences, 0);

    var userName: String
        get() = prefs.getString(username, "")!!
        set(value) = prefs.edit().putString(username, value).apply()

    var registerPhoneNo: String
        get() = prefs.getString(registerMobNo, "")!!
        set(value) = prefs.edit().putString(registerMobNo, value).apply()

    var phoneVerificationId: String
        get() = prefs.getString(verificationId, "")!!
        set(value) = prefs.edit().putString(verificationId, value).apply()

    var phoneVerificationToken: String
        get() = prefs.getString(token, "")!!
        set(value) = prefs.edit().putString(token, value).apply()
}