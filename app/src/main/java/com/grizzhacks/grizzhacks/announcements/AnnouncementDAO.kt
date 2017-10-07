package com.grizzhacks.grizzhacks.announcements

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

/**
 * Database access for announcements.
 */
@Dao
interface AnnouncementDAO {
    /**
     * Retrieves all announcements that are stored in the database.
     */
    @Query("SELECT * FROM announcement")
    fun getAll(): Flowable<List<Announcement>>

    /**
     * Inserts a number of announcements into the database.
     */
    @Insert
    fun insert(announcements: List<Announcement>): List<Long>
}