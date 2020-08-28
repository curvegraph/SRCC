package com.sriraghunanthancarcare

import android.app.Application
import android.content.Context
import com.sriraghunanthancarcare.customer.util.Prefs

val pref by lazy {
    App.prefs!!
}

val screenDensity by lazy {
    App.density!!
}
val screenWidth by lazy {
    App.width!!
}
val screenHeight by lazy {
    App.height!!
}
class App : Application() {

    companion object {
        var prefs: Prefs? = null

        var density: Float? = null
        var width: Int? = null
        var height: Int? = null
        var appContext: Context? = null
    }

    override fun onCreate() {
        appContext = applicationContext
        prefs = Prefs(applicationContext)
        density = resources.displayMetrics.density
        width = resources.displayMetrics.widthPixels
        height = resources.displayMetrics.heightPixels
        super.onCreate()
    }

}