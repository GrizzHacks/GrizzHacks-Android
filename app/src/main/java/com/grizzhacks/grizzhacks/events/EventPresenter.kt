package com.grizzhacks.grizzhacks.events

import io.reactivex.Flowable

/**
 * Presenter for interacting events.
 */
interface EventPresenter {
    /**
     * Used to retrieve the announcements.
     */
    fun fetch()

    /**
     * When the view is destroyed.
     */
    fun onDestroy()
}