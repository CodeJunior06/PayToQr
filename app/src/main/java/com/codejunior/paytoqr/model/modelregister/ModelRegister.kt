package com.codejunior.paytoqr.model.modelregister

import com.codejunior.paytoqr.model.network.MongoDB

data class ModelRegister(val emailRegister:String,val password:String) {

    private val mongoDatabase:MongoDB = MongoDB()

    fun authRegister(){
        mongoDatabase.registerNewUser(emailRegister,password)
    }
}