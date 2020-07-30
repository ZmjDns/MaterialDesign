package com.zmj.materialdesign.common

import android.content.Context
import android.content.res.Configuration
import android.widget.Toast

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/24
 * Description :
 */

fun showToast(context: Context,msg: String){
    Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
}
//判断是否在深色主题
fun isDarkTheme(context: Context): Boolean{
    val flag = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
    return flag == Configuration.UI_MODE_NIGHT_YES
}