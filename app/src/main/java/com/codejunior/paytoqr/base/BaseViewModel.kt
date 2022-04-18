package com.codejunior.paytoqr.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel:ViewModel(){

    val error:MutableLiveData<ERROR> = MutableLiveData(null)
    private val success:MutableLiveData<SUCCESS> = MutableLiveData(null)
    val navegation:MutableLiveData<NAVIGATION> = MutableLiveData(null)
    val utils:MutableLiveData<UTILS> = MutableLiveData(null)

    enum class ERROR {
        ERROR_EMPTY,
        EMPTY_FIELD,
        PASSWORD_NOT_COINCIDER
    }
    enum class SUCCESS {

    }

    enum class NAVIGATION {
        NAV_REGISTER,
        NAV_MENU,
        NAV_LOGIN,
        NAV_EMPTY

    }
    enum class UTILS{
        DIALOG_PRE_DESIGN,
        DIALOG_EMPTY
    }

    fun clear(){
        error.value = ERROR.ERROR_EMPTY
        navegation.value = NAVIGATION.NAV_EMPTY
        utils.value = UTILS.DIALOG_EMPTY

    }




}