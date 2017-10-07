package com.grizzhacks.grizzhacks.events

import android.content.Context
import com.grizzhacks.grizzhacks.core.EntityInteractor
import io.reactivex.Flowable

/**
 * Pulls the announcements from the data source.
 */
class EventInteractor(private val context: Context): EntityInteractor<Event> {
    override fun fetch(): Flowable<List<Event>> {
        return Flowable.just(listOf(Event("Intro To Android"), Event("Intro To iOS")))

//        return GHDatabase.getInMemoryDatabase(context)
//                .eventDao()
//                .getAll()
    }
}