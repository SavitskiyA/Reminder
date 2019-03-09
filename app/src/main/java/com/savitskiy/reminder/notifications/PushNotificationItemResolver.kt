package com.savitskiy.reminder.notifications

import android.content.Context

/**
 * Created by andrey on 09,March,2019
 */
interface PushNotificationItemResolver {
    fun resolve(context: Context): PushNotificationItem
}