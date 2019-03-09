package com.savitskiy.reminder.alarm

import android.app.PendingIntent
import android.content.Context
import com.savitskiy.reminder.receivers.AlarmReceiver

/**
 * Created by andrey on 09,March,2019
 */
class AlarmManagerImpl() : AlarmManager {
    override fun setAlarm(context: Context, delay: Long) {
        val intent = AlarmReceiver.getIntent(context)

        val pIntent = PendingIntent.getBroadcast(
            context, System.currentTimeMillis().toInt(), intent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )
        val am = context.getSystemService(Context.ALARM_SERVICE) as android.app.AlarmManager
        am.set(android.app.AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + delay, pIntent)
    }

}