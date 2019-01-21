package com.xiaomi.fluttermipush

import android.app.ActivityManager
import android.content.Context
import android.os.Process
import android.util.Log
import com.xiaomi.mipush.sdk.MiPushClient
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class FlutterMiPushPlugin(private val context: Context) : MethodCallHandler {
  companion object {
    private const val TAG = "FlutterMiPushPlugin"

    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "flutter_mi_push")
      channel.setMethodCallHandler(FlutterMiPushPlugin(registrar.context()))
    }
  }

  override fun onMethodCall(call: MethodCall, result: Result) {
    when {
      call.method == "init" -> init(call, result)
      else -> result.notImplemented()
    }
  }

  private fun init(call: MethodCall, result: Result) {
    Log.d(TAG, "init")
    val appId = call.argument<String>("appId")
    val appKey = call.argument<String>("appKey")
    if (shouldInit(context)) {
      MiPushClient.registerPush(context, appId, appKey)
    }
    result.success("success")
  }

  private fun shouldInit(context: Context): Boolean {
    val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val processInfoList = am.runningAppProcesses
    val mainProcessName = context.packageName
    val myPid = Process.myPid()
    for (info in processInfoList) {
      if (info.pid === myPid && mainProcessName == info.processName) {
        Log.d(TAG, "shouldInit: true")
        return true
      }
    }
    Log.d(TAG, "shouldInit: false")
    return false
  }
}
