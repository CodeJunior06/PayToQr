package com.codejunior.paytoqr.base

import android.app.Application
import io.realm.BuildConfig

import io.realm.Realm

class BaseApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this);

        if(BuildConfig.DEBUG){

        }

    }
}