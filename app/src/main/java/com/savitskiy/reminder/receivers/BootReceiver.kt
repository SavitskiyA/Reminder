package com.savitskiy.reminder.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.savitskiy.reminder.services.RecentRunService

/**
 * Created by andrey on 09,March,2019
 */
class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        RecentRunService.enqueueWork()
    }

    companion object {
        const val TAG = "BootReceiver"
    }
}