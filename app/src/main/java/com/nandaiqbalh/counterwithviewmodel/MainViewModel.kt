package com.nandaiqbalh.counterwithviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    val vCounter: MutableLiveData<Int> = MutableLiveData(0)

    fun incrementCount(){
        vCounter.postValue(vCounter.value?.plus(1))
    }

    fun decrementCount(){
        vCounter.value?.let {
            if (it > 0 ) {
                vCounter.postValue(vCounter.value?.minus(1))
            }
        }
    }
}
