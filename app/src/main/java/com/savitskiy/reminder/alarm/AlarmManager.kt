package com.savitskiy.reminder.alarm

import android.content.Context

/**
 * Created by andrey on 09,March,2019
 */
interface AlarmManager {
    fun setAlarm(context: Context, delay: Long)
}