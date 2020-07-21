package com.khurram.architecturecomponent.network


import com.khurram.architecturecomponent.util.Constants
import com.khurram.architecturecomponent.util.Friend
import retrofit2.HttpException
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Abstract Base Data source class with error handling
 */
abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): ResultType<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                val code = response.code()

                if (body != null) return ResultType.success(data = body, code = code)
            }
            return error(message = response.message(), code = response.code())
        } catch (e: Exception) {
            when (e) {
                is HttpException -> {
                    return if (e.code()>=Constants.INTERNAL_SERVER_ERROR_CODE){
                        error(message = "Internal server error. please check your backend", code = e.code())
                    }else{
                        // 400 series will be caterd here
                        var errorMessage = Friend.ErrorMessage(e.response()?.errorBody().toString())
                        error(message = errorMessage,code = e.code())
                    }
                }
                is SocketTimeoutException -> {
                    return error(message = "Session Time out, please check your connection.")
                }
                is UnknownHostException -> {
                    return error(message = "No internet access, please check your connection.")
                }
                else -> {
                    return error(message = e.localizedMessage)
                }
            }
        }
    }

    private fun <T> error(message: String,code : Int=0): ResultType<T> {
        return ResultType.error(message = message,code = code)
    }

}

