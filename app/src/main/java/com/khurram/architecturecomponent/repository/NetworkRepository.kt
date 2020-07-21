package com.khurram.architecturecomponent.repository

import com.khurram.architecturecomponent.network.APIsInterface
import com.khurram.architecturecomponent.network.BaseDataSource
import javax.inject.Inject

class NetworkRepository @Inject constructor(var apIsInterface: APIsInterface) : BaseDataSource() {

    suspend fun getAllUsers(page : Int=1) = getResult { apIsInterface.getAllUsers(page)}

}