package com.codejunior.paytoqr.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel:ViewModel(){

    val error:MutableLiveData<ERROR> = MutableLiveData(null)
    private val success:MutableLiveData<SUCCESS> = MutableLiveData(null)
    val navegation:MutableLiveData<NAVIGATION> = MutableLiveData(null)


    enum class ERROR {
        EMPTY_FIELD,
        PASSWORD_NOT_COINCIDER
    }
    enum class SUCCESS {

    }

    enum class NAVIGATION {
        NAV_REGISTER,
        NAV_MENU,
        NAV_LOGIN

    }




}