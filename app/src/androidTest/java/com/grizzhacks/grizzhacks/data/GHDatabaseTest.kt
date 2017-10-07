package com.grizzhacks.grizzhacks.data

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.grizzhacks.grizzhacks.MainActivity
import com.grizzhacks.grizzhacks.announcements.Announcement
import com.grizzhacks.grizzhacks.announcements.AnnouncementDAO
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

/**
 * Tests the local Room database.
 */
@RunWith(AndroidJUnit4::class)
class GHDatabaseTest {
    private lateinit var database: GHDatabase
    private lateinit var announcementDao: AnnouncementDAO

    @JvmField @Rule val instantTaskExecutorRule = InstantTaskExecutorRule()
    @JvmField @Rule val mainActivity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp() {
        val context = mainActivity.activity
        database = Room.inMemoryDatabaseBuilder(context, GHDatabase::class.java).allowMainThreadQueries().build()
        announcementDao = database.announcementDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun writeReadAnnouncement() {
        val testAnnouncement = Announcement("TEST_HEADER", "TEST_BODY", Date())

        val ids = announcementDao.insert(listOf(testAnnouncement))
        assertEquals(1, ids.size)
        testAnnouncement.id = ids.first()

        announcementDao.getAll()
                .test()
                .assertValue(listOf(testAnnouncement))
    }
}