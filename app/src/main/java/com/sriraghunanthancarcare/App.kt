package com.sriraghunanthancarcare

import android.app.Application
import android.content.Context
import com.sriraghunanthancarcare.customer.util.Prefs

val pref by lazy {
    App.prefs!!
}
class App : Application() {

    companion object {
        var prefs: Prefs? = null
        var width: Int? = null
        var height: Int? = null
        var appContext: Context? = null
    }

    override fun onCreate() {
        appContext = applicationContext
        prefs = Prefs(applicationContext)
        super.onCreate()
    }

}