package com.savitskiy.reminder.storage

/**
 * Created by andrey on 09,March,2019
 */
interface Storage {
    fun getLastRun(): Long
    fun setLastRun(millisec: Long)
}