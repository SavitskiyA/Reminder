package com.savitskiy.reminder.notifications.impl

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.savitskiy.reminder.notifications.PushNotificationBuilder
import com.savitskiy.reminder.notifications.PushNotificationItem
import com.savitskiy.reminder.notifications.PushNotificationItemResolver
import com.savitskiy.reminder.notifications.PushNotificationManager

/**
 * Created by andrey on 09,March,2019
 */
class PushNotificationManagerImpl(
    private val notificationManager: NotificationManager,
    private val resolver: PushNotificationItemResolver,
    private val notificationBuilder: PushNotificationBuilder
) : PushNotificationManager {
    override fun show(context: Context) {
        val notification = resolver.resolve(context)
        createChennelIfNecessary(notification, context)
        notificationManager.notify(
            notification.id(),
            notificationBuilder.build(context, notification)
        )
    }

    private fun createChennelIfNecessary(
        notification: PushNotificationItem,
        context: Context
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (!notificationChannelExists(notification.channel().channelId)) {
                createChannel(context, notification.channel())
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannel(context: Context, channel: PushNotificationChannel) {
        val channelTitle = context.getString(channel.titleResource)
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val notificationChannel = NotificationChannel(channel.channelId, channelTitle, importance)
        notificationChannel.setShowBadge(true)
        notificationChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
        notificationManager.createNotificationChannel(notificationChannel)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun notificationChannelExists(channelId: String): Boolean =
        notificationManager.getNotificationChannel(channelId) != null
}