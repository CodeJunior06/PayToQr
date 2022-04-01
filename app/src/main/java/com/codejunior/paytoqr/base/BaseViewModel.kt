package com.codejunior.paytoqr.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel:ViewModel(){

    private val error:MutableLiveData<ERROR> = MutableLiveData()
    private val success:MutableLiveData<SUCCESS> = MutableLiveData()
    private val navegation:MutableLiveData<NAVIGATION> = MutableLiveData()


    enum class ERROR {

    }
    enum class SUCCESS {

    }

    enum class NAVIGATION {

    }




}