package com.codejunior.paytoqr.model.modelregister.POJO

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import org.bson.types.ObjectId
import java.util.*

class DataRegister {
    var email:String?=""
    var password:String? =""
    var password_intent:String? = ""
}
