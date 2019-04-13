package com.savitskiy.reminder.alarm

import android.annotation.TargetApi
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
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
        am.set(
            android.app.AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis() + delay,
            pIntent
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setAlarmMAndAbove(am, pIntent, delay)
        } else {
            setAlarmBelowM(am, pIntent, delay)
        }


    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setAlarmMAndAbove(
        alarmManager: android.app.AlarmManager,
        pendingIntent: PendingIntent,
        delay: Long
    ) {
        alarmManager.setAndAllowWhileIdle(
            android.app.AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis() + delay,
            pendingIntent
        )
    }

    private fun setAlarmBelowM(
        alarmManager: android.app.AlarmManager,
        pendingIntent: PendingIntent,
        delay: Long
    ) {
        alarmManager.set(
            android.app.AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis() + delay,
            pendingIntent
        )
    }

}