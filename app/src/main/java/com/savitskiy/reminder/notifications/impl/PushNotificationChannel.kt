package com.savitskiy.reminder.notifications.impl

import androidx.annotation.StringRes
import com.savitskiy.reminder.R

/**
 * Created by andrey on 09,March,2019
 */
sealed class PushNotificationChannel(val channelId: String, @StringRes val titleResource: Int) {
    class Reminder : PushNotificationChannel("reminder_id", R.string.reminder_channel)
}