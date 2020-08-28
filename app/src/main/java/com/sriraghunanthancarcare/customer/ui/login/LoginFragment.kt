package com.sriraghunanthancarcare.customer.ui.login

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import com.sriraghunanthancarcare.customer.R
import com.sriraghunanthancarcare.customer.util.*
import kotlinx.android.synthetic.main.content_login.*
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private var duration = 1000L
    private var logoY = 0f

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contentLogo.visibility = View.VISIBLE
        contentLoginWelcome.visibility = View.GONE

        contentLogo.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                contentLogo.viewTreeObserver.removeOnGlobalLayoutListener(this)

                if (false) {
                    initLogin()
                } else {
                    Handler().postDelayed({
                        //   toGoNextScreen()
                    }, 2000)


                }

            }
        })
    }

    private fun initLogin() {
        logoY = contentLogo.y
        showLogin(true)
    }


    fun showLogin(boolean: Boolean) {
        val position = logoY - ((logoY / 2) - (contentLogo.height / 2))
        if (boolean) {
            transitionY(contentLogo, -position, duration / 2)
            showView(contentLoginWelcome, duration)
        } else {
            transitionY(contentLogo, 0f, duration)
            hideView(contentLoginWelcome, duration / 2)
        }


    }
}