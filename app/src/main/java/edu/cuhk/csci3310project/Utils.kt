package edu.cuhk.csci3310project

import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.material3.AlertDialog
import androidx.core.content.ContextCompat

fun Context.isPermissionGranted(permission: String): Boolean{
    return ContextCompat.checkSelfPermission(this,permission) == PackageManager.PERMISSION_GRANTED
}

inline fun Context.cameraPermissionRequest(crossinline positive:() -> Unit){
    AlertDialog.Builder()
}