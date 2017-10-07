package com.grizzhacks.grizzhacks.core

import com.grizzhacks.grizzhacks.announcements.Announcement
import io.reactivex.Flowable


/**
 * Retrieves a list of entities from the database and/or server.
 */
interface EntityInteractor<T> {
    fun fetch(): Flowable<List<T>>
}