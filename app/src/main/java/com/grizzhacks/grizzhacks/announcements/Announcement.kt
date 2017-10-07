package com.grizzhacks.grizzhacks.announcements

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * An alert that can be sent to all of the users.
 */
@Entity
data class Announcement(
        var header: String = "",
        var body: String = "",
        var date: Date = Date(),
        @PrimaryKey(autoGenerate = true) var id: Long = 0L
)