package com.jeetracker.app.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationHelper {
    const val CHANNEL_ID = "jee_tracker_channel"
    fun createChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "JEE Tracker Notifications"
            val desc = "Reminders for study sessions and revisions"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val chan = NotificationChannel(CHANNEL_ID, name, importance)
            chan.description = desc
            val nm = context.getSystemService(NotificationManager::class.java)
            nm.createNotificationChannel(chan)
        }
    }

    fun showNotification(context: Context, title: String, text: String, id: Int = 1001) {
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(title)
            .setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(context)) {
            notify(id, builder.build())
        }
    }
}
