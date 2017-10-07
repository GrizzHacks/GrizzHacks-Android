package com.grizzhacks.grizzhacks.events

import io.reactivex.Flowable

/**
 * Interacts with the events.
 */
interface EventInteractor {
    fun fetch(): Flowable<List<Event>>
}