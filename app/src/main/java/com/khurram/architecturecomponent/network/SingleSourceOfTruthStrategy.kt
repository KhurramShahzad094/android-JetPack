package com.khurram.architecturecomponent.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

fun <T> resultLiveData(
                          networkCall: suspend () -> ResultType<T>
): LiveData<ResultType<T>> =
        liveData(Dispatchers.IO) {
            emit(ResultType.loading<T>())
            val responseStatus = networkCall.invoke()
            if (responseStatus.status == ResultType.Status.SUCCESS) {
                ResultType.success(responseStatus.data!!,responseStatus.code)
                emit(ResultType.success(responseStatus.data,responseStatus.code))
            } else if (responseStatus.status == ResultType.Status.ERROR) {
                emit(ResultType.error<T>(responseStatus.message!!,code = responseStatus.code))
            }
        }