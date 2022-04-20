package com.codejunior.paytoqr.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

class Utilities {


    companion object {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

         fun alertDialogSimple(context:Context, positiveButtonClick:(DialogInterface,Int)->Unit,negativeButtonClick:(DialogInterface,Int)->Unit){
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Regresar a login")
            builder.setMessage("¡UPS! tienes informacion en la vista, deseas regresar de igual manera?")
            builder.setPositiveButton("SI", DialogInterface.OnClickListener(function = positiveButtonClick))
            builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener(function = negativeButtonClick))
            builder.setCancelable(false)
            builder.show()

        }
    }
}