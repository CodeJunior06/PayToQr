package com.codejunior.paytoqr.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codejunior.paytoqr.base.BaseApplication.Companion.app
import com.codejunior.paytoqr.base.BaseViewModel
import com.codejunior.paytoqr.model.modelregister.POJO.DataRegister

class RegisterViewModel : BaseViewModel() {
    // TODO: Implement the ViewModel

    private val _user: MutableLiveData<DataRegister?> = MutableLiveData<DataRegister?>(
        DataRegister()
    )
    val userRegister: LiveData<DataRegister?> get() = _user
    val email: String by lazy { userRegister.value?.email ?: "" }
    val password: String by lazy { userRegister.value?.password ?: "" }
    val passwordIntent: String by lazy { userRegister.value?.password_intent ?: "" }
    fun AcceptLogin() {

       /* val email = userRegister.value?.email ?:""
         val password = userRegister.value?.password ?:""
         val paaswordIntent = userRegister.value?.password_intent ?:""*/

        val array = arrayOf(validEmail(), validPassword())


        app.emailPassword.registerUserAsync(
            email,
            password
        ) {
            if (it.isSuccess) {
                println("REGISTRO")
            } else {
                println("NO REGISTRO")
            }
        }
    }

    private fun validEmail() {
        val app: String
        return (if (email.isEmpty()) {
            false
        } else if (password.isEmpty())
            false) as Unit



    }

    fun validPassword(): Boolean {

        return false
    }

}