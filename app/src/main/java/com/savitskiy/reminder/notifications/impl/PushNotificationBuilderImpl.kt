package com.savitskiy.reminder.notifications.impl

import android.app.Notification
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.savitskiy.reminder.R
import com.savitskiy.reminder.notifications.PushNotificationBuilder
import com.savitskiy.reminder.notifications.PushNotificationItem

/**
 * Created by andrey on 09,March,2019
 */
class PushNotificationBuilderImpl : PushNotificationBuilder {
    override fun build(context: Context, item: PushNotificationItem) =
        NotificationCompat.Builder(context, item.channel().channelId)
            .setContentIntent(item.pendingIntent())
            .setLargeIcon(item.largeIcon())
            .setSmallIcon(item.smallIcon())
            .setContentTitle(item.title())
            .setContentText(item.message())
            .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
            .setAutoCancel(true)
            .setStyle(NotificationCompat.BigTextStyle().bigText(item.message()))
            .setDefaults(Notification.DEFAULT_ALL)
            .build()
}