package com.savitskiy.reminder.services

import android.content.Intent
import androidx.core.app.JobIntentService
import org.koin.standalone.KoinComponent

/**
 * Created by andrey on 09,March,2019
 */
class RecentRunService : JobIntentService(), KoinComponent {

    override fun onHandleWork(intent: Intent) {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        const val JOB_ID = 0x01
        const val TAG = "RecentRunService"
        private val DELAY = 10000L
    }
}