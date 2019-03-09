package com.savitskiy.reminder.notifications

import android.app.Notification
import android.content.Context

/**
 * Created by andrey on 09,March,2019
 */
interface PushNotificationBuilder {
    fun build(context: Context, item: PushNotificationItem): Notification
}