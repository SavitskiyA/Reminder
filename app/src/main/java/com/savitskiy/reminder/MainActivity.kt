package com.savitskiy.reminder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.savitskiy.reminder.services.RecentRunService
import com.savitskiy.reminder.storage.Storage
import org.koin.android.ext.android.inject
import org.koin.standalone.inject

class MainActivity : AppCompatActivity() {

    val storage: Storage by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (storage.isFirstRun()) {
            RecentRunService.enqueueWork()
            storage.setIsFirstRun(false)
        }

        storage.setLastRun(System.currentTimeMillis())
    }

    companion object {
        const val TAG = "MainActivity"
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
