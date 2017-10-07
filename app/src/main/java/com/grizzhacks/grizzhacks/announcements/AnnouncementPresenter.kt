package com.grizzhacks.grizzhacks.announcements

import io.reactivex.Flowable

/**
 * Presenter for interacting announcements.
 */
interface AnnouncementPresenter {
    /**
     * Used to retrieve the announcements.
     */
    fun fetch()

    /**
     * When the view is destroyed.
     */
    fun onDestroy()
}