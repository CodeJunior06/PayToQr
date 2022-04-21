package com.codejunior.paytoqr.model.network

import com.codejunior.paytoqr.base.BaseApplication.Companion.app

class MongoDB {

    fun registerNewUser(email:String,password: String) {
        app.emailPassword.registerUserAsync(
            email,
            password
        ) {
            if (it.isSuccess) {
                it.get()
                println("REGISTRO")
            } else {
                println("NO REGISTRO")
            }
        }

    }
}