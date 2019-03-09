package com.savitskiy.reminder.notifications.impl

import android.content.Context
import com.savitskiy.reminder.notifications.PushNotificationItem
import com.savitskiy.reminder.notifications.PushNotificationItemResolver

/**
 * Created by andrey on 09,March,2019
 */
class PushNotificationItemResolverImpl():PushNotificationItemResolver {
    override fun resolve(context: Context) = ReminderNotificationItem(context)
}