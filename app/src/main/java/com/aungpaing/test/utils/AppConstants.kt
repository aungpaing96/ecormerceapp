package com.aungpaing.test.utils

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.aungpaing.test.R
import java.text.SimpleDateFormat
import java.util.*

// Uat
//const val BASE_URL = "http://150.95.30.152:8080/restaurantuat/"

// New
const val BASE_URL = "https://quickstart-b0425a51.myshopify.com/admin/api/"

const val IMAGE_BASE_URL = "https://quickstart-b0425a51.myshopify.com/admin/api/"

const val ITEM_LIST_URL = "2024-07/products.json"

var AUTHORIZATION = "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"

var SIZE_LIST_SIZE = 0
var BRAND_LIST_SIZE = 0

fun setUpLoadingDialog(context: Context): Dialog {
    val dialog = Dialog(context)
    val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val view = layoutInflater.inflate(R.layout.dialog_loading, null,false)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(view)
    dialog.setCancelable(false)
    dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
    dialog.create()
    return dialog
}

fun isNetwork(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected) {
        return true
    }
    return false
}

fun showErrorDialog(context: Context, message: String) {
    val builder = AlertDialog.Builder(context)
    builder.setIcon(R.drawable.ic_info_outline_black_24dp)
    builder.setTitle(context.getString(R.string.fail))
    builder.setMessage(message)
    builder.setPositiveButton(context.getString(R.string.ok), object: DialogInterface.OnClickListener {
        override fun onClick(p0: DialogInterface?, p1: Int) {

        }
    })
    builder.setCancelable(false)
    builder.show()
}

fun showInfoDialog(context: Context, message: String) {
    val builder = AlertDialog.Builder(context)
    builder.setIcon(R.drawable.ic_info_outline_black_24dp)
    builder.setTitle(context.getString(R.string.info))
    builder.setMessage(message)
    builder.setPositiveButton(context.getString(R.string.ok), object: DialogInterface.OnClickListener {
        override fun onClick(p0: DialogInterface?, p1: Int) {

        }
    })
    builder.setCancelable(false)
    builder.show()
}

fun showSuccessDialog(context: Context, message: String) {
    val builder = AlertDialog.Builder(context)
    builder.setIcon(R.drawable.ic_info_outline_black_24dp)
    builder.setTitle(context.getString(R.string.success))
    builder.setMessage(message)
    builder.setPositiveButton(context.getString(R.string.ok), object: DialogInterface.OnClickListener {
        override fun onClick(p0: DialogInterface?, p1: Int) {

        }
    })
    builder.setCancelable(false)
    builder.show()
}

fun setUpListDialog(context: Context): Dialog {
    val dialog = Dialog(context)
    val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val view = layoutInflater.inflate(R.layout.list_dialog, null,false)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(view)
    dialog.setCancelable(true)
    dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
    dialog.create()
    return dialog
}

fun showNetworkDialog(context: Context): Dialog {
    val dialog = Dialog(context)
    val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val view = layoutInflater.inflate(R.layout.dialog_network, null,false)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(view)
    dialog.setCancelable(true)
    dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
    dialog.create()
    return dialog
}

fun getCurrentDate(context: Context): String {
    return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
}