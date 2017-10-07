package com.grizzhacks.grizzhacks.events

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

/**
 * Database access for events.
 */
@Dao
interface EventDAO {
    /**
     * Retrieves all events that are stored in the database.
     */
    @Query("SELECT * FROM event")
    fun getAll(): Flowable<List<Event>>

    /**
     * Inserts a number of events into the database.
     */
    @Insert
    fun insert(events: List<Event>): List<Long>
}