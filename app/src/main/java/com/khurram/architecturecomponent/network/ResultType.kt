package com.khurram.architecturecomponent.network

/**
 * A generic class that holds a value with its loading status.
 *
 * Result is usually created by the Repository classes where they return
 * `LiveData<Result<T>>` to pass back the latest data to the UI with its fetch status.
 */

data class ResultType<out T>(val status: Status, val data: T?, val message: String?,val code: Int) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T,code : Int): ResultType<T> {
            return ResultType(Status.SUCCESS, data, null,code)
        }

        fun <T> error(message: String, data: T? = null,code : Int): ResultType<T> {
            return ResultType(Status.ERROR, data, message,code)
        }

        fun <T> loading(data: T? = null): ResultType<T> {
            return ResultType(Status.LOADING, data, null,0)
        }
    }
}