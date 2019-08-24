package com.example.schoolapp.Communicator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Communicator : ViewModel() {
    val message = MutableLiveData<Any>()
    fun sendMsgCommunicator(userId : Int){
        message.setValue(userId)
    }
}