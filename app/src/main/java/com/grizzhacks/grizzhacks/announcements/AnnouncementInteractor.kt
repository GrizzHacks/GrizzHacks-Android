package com.grizzhacks.grizzhacks.announcements

import android.content.Context
import com.grizzhacks.grizzhacks.core.EntityInteractor
import io.reactivex.Flowable

/**
 * Pulls the announcements from the data source.
 */
class AnnouncementInteractor(private val context: Context): EntityInteractor<Announcement> {
    override fun fetch(): Flowable<List<Announcement>> {
        return Flowable.just(listOf(Announcement("test1", "test1"), Announcement("test2", "test2")))

//        return GHDatabase.getInMemoryDatabase(context)
//                .announcementDao()
//                .getAll()
    }
}