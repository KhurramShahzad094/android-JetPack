package com.khurram.architecturecomponent.network

import com.khurram.architecturecomponent.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIsInterface {

    @GET("api/users")
    suspend fun getAllUsers(@Query("page") page:Int=1) : Response<UserResponse>
}