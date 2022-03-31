package com.codejunior.paytoqr.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codejunior.paytoqr.base.BaseApplication.Companion.app
import com.codejunior.paytoqr.base.BaseViewModel
import com.codejunior.paytoqr.model.Mlogin
import io.realm.mongodb.App
import io.realm.mongodb.Credentials

class RegisterViewModel : BaseViewModel() {
    // TODO: Implement the ViewModel

    val userRegister: MutableLiveData<Mlogin?> = MutableLiveData<Mlogin?>()
    val test:MutableLiveData<String> = MutableLiveData<String>()
   // val userRegister: LiveData<Mlogin?> = _user


    fun AcceptLogin(){

        var user = test.value ?:""

        app.emailPassword.registerUserAsync(userRegister.value?.email, userRegister.value?.password) {
            if (it.isSuccess) {
                println("REGISTRO")
                println(it.get().toString())
            } else {
                println("NO REGISTRO")
            }
        }
    }
}