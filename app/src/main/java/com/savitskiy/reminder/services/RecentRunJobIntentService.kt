package com.savitskiy.reminder.services

import android.content.Intent
import androidx.core.app.JobIntentService

class RecentRunJobIntentService : JobIntentService() {

    override fun onHandleWork(intent: Intent) {
    }

    companion object {
        const val JOB_ID = 0x01
        const val TAG = "RecentRunJobIntentService"

        private val MILLISECS_PER_DAY = 86400000L
        private val DELAY = MILLISECS_PER_DAY * 6
        private val DELAY_TEST = 10000L
    }
}