package com.khurram.architecturecomponent.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel  : @ViewModelInject ViewModel() {

    var data = MutableLiveData<String>()

}