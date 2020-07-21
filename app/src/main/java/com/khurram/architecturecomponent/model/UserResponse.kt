package com.khurram.architecturecomponent.model

data class UserResponse(var page: Int, var per_page:Int,var total : Int, var total_pages : Int, var data : ArrayList<User>)