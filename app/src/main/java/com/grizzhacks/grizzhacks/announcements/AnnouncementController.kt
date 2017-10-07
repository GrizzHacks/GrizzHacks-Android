package com.grizzhacks.grizzhacks.announcements

/**
 * Controller that handles announcement flow.
 */
interface AnnouncementController {
    /**
     * When the view is resumed and we need to pull announcements again.
     */
    fun onResume()

    /**
     * Called when the announcements are retrieved.
     */
    fun onFetched(announcements: List<Announcement>)

    fun onError(e: Throwable)

    fun showProgress()

    fun hideProgress()
}