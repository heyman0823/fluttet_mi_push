package com.xiaomi.fluttermipush

import android.content.Context
import android.util.Log
import com.xiaomi.mipush.sdk.MiPushCommandMessage
import com.xiaomi.mipush.sdk.MiPushMessage
import com.xiaomi.mipush.sdk.PushMessageReceiver

class MiPushReceiver : PushMessageReceiver() {
    companion object {
        private const val TAG = "MiPushReceiver"
    }

    /**
     * 收到透传消息
     */
    override fun onReceivePassThroughMessage(context: Context?, message: MiPushMessage?) {
        Log.d(TAG, "onReceivePassThroughMessage: message = $message")
    }

    /**
     * 用户点击通知栏消息
     */
    override fun onNotificationMessageClicked(context: Context?, message: MiPushMessage?) {
        Log.d(TAG, "onNotificationMessageClicked: message = $message")
    }

    /**
     * 收到通知栏消息
     */
    override fun onNotificationMessageArrived(context: Context?, message: MiPushMessage?) {
        Log.d(TAG, "onNotificationMessageArrived: message = $message")
    }

    /**
     * 客户端向服务端发送命令消息后的响应
     */
    override fun onCommandResult(context: Context?, message: MiPushCommandMessage?) {
        Log.d(TAG, "onCommandResult: message = $message")
    }

    /**
     * 收到注册结果
     */
    override fun onReceiveRegisterResult(context: Context?, message: MiPushCommandMessage?) {
        Log.d(TAG, "onReceiveRegisterResult: message = $message")
    }
}