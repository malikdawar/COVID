package com.malik.covid.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.text.TextUtils
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.malik.covid.R
import com.malik.covid.view.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class NotificationUtils(private val mContext: Context) {
    private val notificationManager: NotificationManager
            = mContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    private val orderChannelId = "789"

    fun showNotification(title: String?, message: String) { // Check for empty push message

        if (TextUtils.isEmpty(message)) return
        val notificationId = createNotificationId()
        val builder = NotificationCompat.Builder(mContext, orderChannelId)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // you must create a notification channel for API 26 and Above
            createChannel(true)
            builder.setChannelId(orderChannelId)
        }
        builder.setSmallIcon(R.mipmap.ic_launcher)
            .setWhen(0)
            .setStyle(getNotificationStyle(message))
            .setContentTitle(title)
            .setContentText(message)
            .setColor(Color.parseColor("#ff512da8"))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(mainActivityPendingIntent)
            .setAutoCancel(false)
        val notification = builder.build()
        notificationManager.notify(notificationId, notification)
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private fun createChannel(importanceHigh: Boolean) {
        var importance = NotificationManager.IMPORTANCE_DEFAULT
        if (importanceHigh) importance = NotificationManager.IMPORTANCE_HIGH
        val channel =
            NotificationChannel(orderChannelId, "Salaat Channel", importance)
        channel.enableVibration(true)
        channel.enableLights(true)
        channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
        channel.description = "Channel to show Salaat notifications."
        notificationManager.createNotificationChannel(channel)
    }

    private fun getNotificationStyle(line: String): NotificationCompat.InboxStyle {
        val inboxStyle =
            NotificationCompat.InboxStyle()
        inboxStyle.addLine(line)
        return inboxStyle
    }

    private val mainActivityPendingIntent: PendingIntent
        get() {
            val intent = Intent(mContext, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            return PendingIntent.getActivity(mContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        }

    companion object {
        fun createNotificationId(): Int {
            val now = Date()
            return SimpleDateFormat("ddHHmmss", Locale.US).format(now).toInt()
        }
    }
}