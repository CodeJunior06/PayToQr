package com.codejunior.paytoqr.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codejunior.paytoqr.base.BaseViewModel
import com.codejunior.paytoqr.model.modelregister.ModelRegister
import com.codejunior.paytoqr.model.modelregister.POJO.DataRegister
import com.codejunior.paytoqr.utils.Utilities.Companion.emailPattern

class RegisterViewModel : BaseViewModel() {

    private val _user: MutableLiveData<DataRegister?> =
        MutableLiveData<DataRegister?>(DataRegister())
    val userRegister: LiveData<DataRegister?> get() = _user
    private val email: String by lazy { userRegister.value?.email ?: "" }
    private val password: String by lazy { userRegister.value?.password ?: "" }
    private val passwordIntent: String by lazy { userRegister.value?.password_intent ?: "" }

    fun acceptLogin() {

        val rta =validate()

        if (rta == 0){
            val model = ModelRegister(email,password)
            model.authRegister()
        }
    }

    private fun validate()  :Int {
        val array = arrayOf(validEmail(), validPassword())

        return if (false in array) {
            return 1
        } else 0

    }

    private fun validEmail(): Boolean {
        return when {
            email.isEmpty() -> {
                error.value = ERROR.EMPTY_FIELD
                false
            }
            !email.matches(emailPattern.toRegex()) -> {
                false
            }
            else -> true
        }


    }
    private fun validPassword(): Boolean {

        return when {
            password.isEmpty() -> {
                error.value = ERROR.EMPTY_FIELD
                false
            }
            passwordIntent.isEmpty() -> {
                false
            }
            password.length < 6 -> {
                false
            }
            password != passwordIntent ->
                false
            else -> true
        }
    }



    }

