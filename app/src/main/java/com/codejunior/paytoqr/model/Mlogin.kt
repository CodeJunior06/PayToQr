package com.codejunior.paytoqr.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import org.bson.types.ObjectId
import java.util.*

open class Mlogin: RealmObject(){

    @PrimaryKey
    @RealmField("_id")
    var _id: ObjectId = ObjectId()

    var user:String? = ""

    var password:String? =""

    var password_intent:String? = ""

    var email:String?=""



}
