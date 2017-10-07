package com.grizzhacks.grizzhacks.announcements

/**
 * Controller that handles announcement flow.
 */
interface AnnouncementController {
    fun onFetched(announcements: List<Announcement>)

    fun onError(e: Throwable)

    fun showProgress()

    fun hideProgress()
}