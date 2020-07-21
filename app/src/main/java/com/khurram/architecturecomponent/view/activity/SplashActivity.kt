package com.khurram.architecturecomponent.view.activity

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.khurram.architecturecomponent.R
import com.khurram.architecturecomponent.databinding.ActivitySplashBinding
import com.khurram.architecturecomponent.util.Friend
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //        for activity binding in activity on create
        val binding : ActivitySplashBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_splash)


        val supportActionBar: ActionBar? =
            (this as AppCompatActivity).supportActionBar
        supportActionBar?.hide()

        val jsonColor= "#ffffff"
        binding.backgroundColor=jsonColor
        var color = jsonColor.removeRange(0,1)

        var startColor:Int= Color.parseColor("#00${color}")
        var centerColor:Int= Color.parseColor("#66${color}")
        var endColor:Int= Color.parseColor("#ff${color}")
        val gradientDrawable = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(startColor,centerColor,endColor)
            )
        var blackColor= Color.parseColor("#000000")
        gradientDrawable.setStroke(1,blackColor)

        Friend.setBackgroundAndFrameColor(ll_singleColor,"#ffffff","#000000")

//        val simpleColorDrawable = GradientDrawable(
//            GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(endColor,endColor)
//        )

//        ll_singleColor.background=simpleColorDrawable

        ll_multicolor.background = gradientDrawable
    }
}