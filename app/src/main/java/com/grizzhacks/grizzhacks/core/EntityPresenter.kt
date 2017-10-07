package com.grizzhacks.grizzhacks.core

/**
 * Presents entities on the screen and handles the view being destroyed.
 */
interface EntityPresenter {
    /**
     * Used to retrieve the entities.
     */
    fun fetch()

    /**
     * When the view is destroyed.
     */
    fun onDestroy()
}