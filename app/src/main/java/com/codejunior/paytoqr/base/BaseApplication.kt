package com.codejunior.paytoqr.base

import android.app.Application
import com.codejunior.paytoqr.R
import io.realm.BuildConfig

import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.log.LogLevel
import io.realm.log.RealmLog
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration

class BaseApplication:Application() {

    companion object {
        const val appID: String = "paywithqr-xitha"
        val app:App by lazy { App(AppConfiguration.Builder(appID).appName(BuildConfig.VERSION_NAME).build()) }
    }

    override fun onCreate() {
        super.onCreate()

        Realm.init(this);

        val config = RealmConfiguration.Builder()
            .name("payQr.db")
            .schemaVersion(1)
            .build()

        Realm.setDefaultConfiguration(config)

        if(BuildConfig.DEBUG){
            RealmLog.setLevel(LogLevel.DEBUG)
        }else{
            RealmLog.setLevel(LogLevel.INFO)
        }

    }

}