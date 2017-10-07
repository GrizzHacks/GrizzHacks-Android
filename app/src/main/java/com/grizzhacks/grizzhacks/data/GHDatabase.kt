package com.grizzhacks.grizzhacks.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import android.util.EventLog
import com.grizzhacks.grizzhacks.announcements.Announcement
import com.grizzhacks.grizzhacks.announcements.AnnouncementDAO
import com.grizzhacks.grizzhacks.events.Event
import com.grizzhacks.grizzhacks.events.EventDAO

/**
 * Database that holds all of the information for GrizzHacks locally.
 */
@Database(entities = arrayOf(Announcement::class, Event::class), version = 1)
@TypeConverters(Converters::class)
abstract class GHDatabase : RoomDatabase() {
    abstract fun announcementDao(): AnnouncementDAO
    abstract fun eventDao(): EventDAO

    companion object {
        private var INSTANCE: GHDatabase? = null
            private set

        fun getInMemoryDatabase(context: Context): GHDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context,
                        GHDatabase::class.java, "grizzhacks.db")
                        .build()
            }

            return INSTANCE!!
        }
    }
}