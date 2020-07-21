package com.khurram.architecturecomponent.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.khurram.architecturecomponent.model.UserResponse
import com.khurram.architecturecomponent.network.ResultType
import com.khurram.architecturecomponent.network.resultLiveData
import com.khurram.architecturecomponent.repository.NetworkRepository

class HomeViewModel @ViewModelInject constructor(var networkRepository: NetworkRepository) : ViewModel() {

    fun getAllUsers(page: Int=1): LiveData<ResultType<UserResponse>> {
        return  resultLiveData { networkRepository.getAllUsers(page)  }
    }
}