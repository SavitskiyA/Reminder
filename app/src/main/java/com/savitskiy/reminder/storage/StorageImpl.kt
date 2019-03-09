package com.savitskiy.reminder.storage

import android.content.SharedPreferences

/**
 * Created by andrey on 09,March,2019
 */
class StorageImpl(private val sharedPreferences: SharedPreferences) : Storage {

    private val editor by lazy { sharedPreferences.edit() }

    override fun getLastRun() = sharedPreferences.getLong(LAST_RUN_KEY, 0)

    override fun setLastRun(millisec: Long) {
        editor.putLong(LAST_RUN_KEY, millisec).commit()
    }

    override fun isFirstRun() = sharedPreferences.getBoolean(IS_FIRST_RUN_KEY, true)

    override fun setIsFirstRun(isFirstRun: Boolean) {
        editor.putBoolean(IS_FIRST_RUN_KEY, isFirstRun).commit()
    }

    companion object {
        private const val TAG = "StorageImpl"
        private const val LAST_RUN_KEY = "last_run_key"
        private const val IS_FIRST_RUN_KEY = "is_first_run_key"
    }
}