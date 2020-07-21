package com.khurram.architecturecomponent.view.activity

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.khurram.architecturecomponent.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


//  credit to
// https://proandroiddev.com/android-architecture-starring-kotlin-coroutines-jetpack-mvvm-room-paging-retrofit-and-dagger-7749b2bae5f7

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var navController = findNavController(R.id.nav_host_fragment)
        bottom_navbar.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this,findNavController(R.id.nav_host_fragment))






    }

    override fun onSupportNavigateUp(): Boolean {
        return  findNavController(R.id.nav_host_fragment).navigateUp()
    }


    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl", "error")
        fun loadImage(view: ImageView, url: String?, error: Drawable) {
            if (url!=null) {
                Glide.with(view.context).load(url)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(error)
                    .into(view)
            }
        }
    }
}