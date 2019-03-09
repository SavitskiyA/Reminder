package com.savitskiy.reminder.services

import android.content.Intent
import androidx.core.app.JobIntentService
import com.savitskiy.reminder.App.Companion.context
import com.savitskiy.reminder.alarm.AlarmManager
import com.savitskiy.reminder.notifications.PushNotificationManager
import com.savitskiy.reminder.storage.Storage
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

/**
 * Created by andrey on 09,March,2019
 */
class RecentRunService : JobIntentService(), KoinComponent {

    val notificationManager: PushNotificationManager by inject()
    val alarmManager: AlarmManager by inject()
    val storage: Storage by inject()

    override fun onHandleWork(intent: Intent) {
        if (storage.getLastRun() < (System.currentTimeMillis() - DELAY)) {
            notificationManager.show(context)
        }
        alarmManager.setAlarm(context, DELAY)
        stopSelf(JOB_ID)
    }

    companion object {
        const val JOB_ID = 0x01
        const val TAG = "RecentRunService"
        private val DELAY = 10000L

        fun enqueueWork() {
            enqueueWork(context, RecentRunService::class.java, JOB_ID, Intent())
        }
    }
}