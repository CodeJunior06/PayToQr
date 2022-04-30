package com.codejunior.paytoqr.model.network

import com.codejunior.paytoqr.base.BaseApplication.Companion.app

class MongoDB {

    fun registerNewUser(email:String,password: String) {

        app.emailPassword.registerUserAsync(
            email,
            password
        ) {
            if (it.isSuccess) {
                println("REGISTRO")
                return@registerUserAsync

            } else {
                println("${it.error.errorIntValue}")
                println("NO REGISTRO")
            }
        }
        println("paso por aqui")
    }
}