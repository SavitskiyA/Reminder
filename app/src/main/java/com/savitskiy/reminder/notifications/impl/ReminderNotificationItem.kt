package com.savitskiy.reminder.notifications.impl

import android.app.PendingIntent
import android.content.Context
import android.graphics.BitmapFactory
import com.savitskiy.reminder.MainActivity
import com.savitskiy.reminder.R
import com.savitskiy.reminder.notifications.PushNotificationItem

/**
 * Created by andrey on 09,March,2019
 */
class ReminderNotificationItem(private val context: Context) : PushNotificationItem {
    override fun id() = System.currentTimeMillis().toInt()

    override fun channel() = PushNotificationChannel.Reminder()

    override fun title() = context.resources.getString(R.string.push_reminder_title)

    override fun message() = context.resources.getString(R.string.push_reminder_message)

    override fun smallIcon() = R.drawable.ic_paw

    override fun pendingIntent() = PendingIntent.getActivity(
        context,
        System.currentTimeMillis().toInt(),
        MainActivity.getIntent(context),
        PendingIntent.FLAG_UPDATE_CURRENT
    )

    override fun largeIcon() =
        BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher_round)
}