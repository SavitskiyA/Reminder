package com.savitskiy.reminder

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.savitskiy.reminder.di.AppModule
import org.koin.android.ext.android.startKoin

/**
 * Created by andrey on 09,March,2019
 */
class App() : Application() {

    override fun onCreate() {
        super.onCreate()

        context = this

        startKoin(this, listOf(AppModule(this).module))
    }

    companion object {
        const val TAG = "App"

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}