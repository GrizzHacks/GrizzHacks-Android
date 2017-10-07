package com.grizzhacks.grizzhacks.events

/**
 * Displays the Events.
 */
interface EventController {
    fun onFetched(events: List<Event>)

    fun onError(e: Throwable)

    fun showProgress()

    fun hideProgress()
}