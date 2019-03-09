package com.savitskiy.reminder.notifications

import android.app.PendingIntent
import android.graphics.Bitmap
import com.savitskiy.reminder.notifications.impl.PushNotificationChannel

/**
 * Created by andrey on 09,March,2019
 */
interface PushNotificationItem {
    fun id(): Int

    fun channel(): PushNotificationChannel

    fun title(): String

    fun message(): String

    fun smallIcon(): Int

    fun pendingIntent(): PendingIntent

    fun largeIcon(): Bitmap
}