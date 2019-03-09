package com.savitskiy.reminder.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.savitskiy.reminder.services.RecentRunService

/**
 * Created by andrey on 09,March,2019
 */
class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == ACTION) {
            RecentRunService.enqueueWork()
        }
    }

    companion object {
        const val TAG = "AlarmReceiver"

        const val ACTION = "com.savitskiy.reminder.intent.action.ALARM"

        fun getIntent(context: Context?) = Intent(context, AlarmReceiver::class.java).apply {
            action = ACTION
        }

    }
}