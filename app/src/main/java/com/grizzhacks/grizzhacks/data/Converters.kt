package com.grizzhacks.grizzhacks.data

import android.arch.persistence.room.TypeConverter
import java.util.*


/**
 * Converter for dates to timestamps.
 */
class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}