package com.grizzhacks.grizzhacks.events

import android.content.Context
import com.grizzhacks.grizzhacks.events.Event
import io.reactivex.Flowable

/**
 * Pulls the announcements from the data source.
 */
class EventInteractorImpl(private val context: Context): EventInteractor {
    override fun fetch(): Flowable<List<Event>> {
        return Flowable.just(listOf(Event("Intro To Android"), Event("Intro To iOS")))

//        return GHDatabase.getInMemoryDatabase(context)
//                .eventDao()
//                .getAll()
    }
}