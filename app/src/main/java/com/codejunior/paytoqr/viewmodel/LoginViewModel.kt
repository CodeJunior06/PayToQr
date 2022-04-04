package com.codejunior.paytoqr.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codejunior.paytoqr.base.BaseViewModel
import com.codejunior.paytoqr.model.modellogin.POJO.DataLogin

open class LoginViewModel : BaseViewModel() {
    private val _user :MutableLiveData<DataLogin?> = MutableLiveData<DataLogin?>(DataLogin())
    val userLogin: LiveData<DataLogin?> get() = _user

    val email:String by lazy { userLogin.value?.email ?:""}
    val password:String by lazy { userLogin.value?.email ?:""}

    fun accessLogin(){
        validLogin()
        navegation.value = NAVIGATION.NAV_MENU
    }

    private fun validLogin(): Int {
        return 0
    }

    fun createAccount(){
        navegation.value =NAVIGATION.NAV_REGISTER
    }

}