package com.khurram.architecturecomponent.util

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import org.json.JSONObject


object Friend {

    // change it according to your error response
    fun ErrorMessage(response: String): String {
        var jsonError = JSONObject(response)
        var message = jsonError.getJSONArray("errors").get(0).toString()
        return message
    }


    fun setBackgroundAndFrameColor(view: View, backgroundColor:String, frameColor:String){
        //use a GradientDrawable with only one color set, to make it a solid color

        //use a GradientDrawable with only one color set, to make it a solid color
        val border = GradientDrawable()
        border.setColor(Color.parseColor(backgroundColor)) //white background
        border.setStroke(1, Color.parseColor(frameColor)) //black border with full opacity
        view.background=border
    }
}