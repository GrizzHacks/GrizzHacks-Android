package com.grizzhacks.grizzhacks.announcements

import io.reactivex.Flowable

/**
 * Interacts with the announcements.
 */
interface AnnouncementInteractor {
    fun fetch(): Flowable<List<Announcement>>
}