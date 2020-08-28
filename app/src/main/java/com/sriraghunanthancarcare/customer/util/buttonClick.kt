package com.sriraghunanthancarcare.customer.util

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Path
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AnimationUtils
import com.sriraghunanthancarcare.customer.R
import com.sriraghunanthancarcare.screenHeight
import com.sriraghunanthancarcare.screenWidth

fun buttonClick(view: View, animInterface: AnimInterface) {
    val context: Context = view.context
    val myAnim = AnimationUtils.loadAnimation(context, R.anim.bounce)

    // Use bounce interpolator with amplitude 0.2 and frequency 20
    val interpolator = MyBounceInterpolator(0.1, 10.0)
    myAnim.interpolator = interpolator
    view.startAnimation(myAnim)
    android.os.Handler().postDelayed({ animInterface.animationCompleted() }, 300)
}

fun buttonClick(view: View) {
    val context: Context = view.context
    val myAnim = AnimationUtils.loadAnimation(context, R.anim.bounce)
    // Use bounce interpolator with amplitude 0.2 and frequency 20
    val interpolator = MyBounceInterpolator(0.1, 10.0)
    myAnim.interpolator = interpolator
    view.startAnimation(myAnim)
}


fun animationArc(view: View, milliSecond: Long, listener: AnimInterface) {
    val path = Path().apply {
        arcTo(0f, 0f, screenWidth / 2f + (view.width/2), screenHeight / 2f- (view.height/2), 270f, -180f, true)
    }
    val animator = ObjectAnimator.ofFloat(view, View.X, View.Y, path).apply {
        duration = milliSecond
        start()
    }.addListener(object : Animator.AnimatorListener {
        override fun onAnimationRepeat(animation: Animator?) {
        }

        override fun onAnimationEnd(animation: Animator?) {
            listener.animationCompleted()
        }

        override fun onAnimationCancel(animation: Animator?) {
        }

        override fun onAnimationStart(animation: Animator?) {
        }
    })

}

fun transitionY(view: View, yPosition: Float, milliSecond: Long) {
    ObjectAnimator.ofFloat(view, "translationY", yPosition).apply {
        duration = milliSecond
        start()
    }
}


fun showView(view: View, milliSecond: Long) {
    // Animate the loading view to 0% opacity. After the animation ends,
    // set its visibility to GONE as an optimization step (it won't
    // participate in layout passes, etc.)
    view.alpha = 0f
    view.visibility = View.VISIBLE
    view.animate()
        .alpha(1f)
        .setDuration(milliSecond)
        .setListener(null)
}

fun hideView(view: View, milliSecond: Long) {
    // Animate the loading view to 0% opacity. After the animation ends,
    // set its visibility to GONE as an optimization step (it won't
    // participate in layout passes, etc.)
    view.animate()
        .alpha(1f)
        .setDuration(milliSecond)
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                view.visibility = View.GONE

            }
        }).start()
}

fun circularAnimation(v: View) {
    // get the center for the clipping circle
    val cx = v.width / 2
    val cy = v.height / 2

    // get the final radius for the clipping circle
    val finalRadius = Math.hypot(cx.toDouble(), cy.toDouble()).toFloat()

    // create the animator for this view (the start radius is zero)
    val anim = ViewAnimationUtils.createCircularReveal(
        v,
        cx,
        cy,
        0f,
        finalRadius
    )
    // make the view visible and start the animation
    v.visibility = View.VISIBLE
    anim.start()
}

interface AnimInterface {
    fun animationCompleted()
}