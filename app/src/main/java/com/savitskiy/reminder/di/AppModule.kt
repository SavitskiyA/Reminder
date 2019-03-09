package com.savitskiy.reminder.di

import android.app.NotificationManager
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.savitskiy.reminder.alarm.AlarmManager
import com.savitskiy.reminder.alarm.AlarmManagerImpl
import com.savitskiy.reminder.notifications.PushNotificationBuilder
import com.savitskiy.reminder.notifications.PushNotificationItemResolver
import com.savitskiy.reminder.notifications.PushNotificationManager
import com.savitskiy.reminder.notifications.impl.PushNotificationBuilderImpl
import com.savitskiy.reminder.notifications.impl.PushNotificationItemResolverImpl
import com.savitskiy.reminder.notifications.impl.PushNotificationManagerImpl
import com.savitskiy.reminder.storage.Storage
import com.savitskiy.reminder.storage.StorageImpl

/**
 * Created by andrey on 09,March,2019
 */
class AppModule(context: Context) {

    val module = org.koin.dsl.module.module {
        single { PreferenceManager.getDefaultSharedPreferences(context) } bind (SharedPreferences::class)
        single { StorageImpl(get()) } bind (Storage::class)

        single { context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager }
        single { PushNotificationItemResolverImpl() } bind (PushNotificationItemResolver::class)
        single { PushNotificationBuilderImpl() } bind (PushNotificationBuilder::class)
        single {
            PushNotificationManagerImpl(
                get(),
                get(),
                get()
            )
        } bind (PushNotificationManager::class)

        single {
            AlarmManagerImpl()
        } bind (AlarmManager::class)
    }
}