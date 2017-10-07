package com.grizzhacks.grizzhacks.events

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Events that can occur throughout the hackathon.
 */
@Entity
data class Event(
        var title: String = "",
        var startDate: Date = Date(),
        var endDate: Date = Date(),
        @PrimaryKey(autoGenerate = true) var id: Long = 0
)