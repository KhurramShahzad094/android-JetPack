package com.khurram.architecturecomponent.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel  : @ViewModelInject ViewModel() {

    public var data = MutableLiveData<String>()

}