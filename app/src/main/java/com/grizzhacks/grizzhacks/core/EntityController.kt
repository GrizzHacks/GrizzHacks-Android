package com.grizzhacks.grizzhacks.core

/**
 * Controller used for fetching and displaying entities.
 */
interface EntityController<in T> {
    fun onFetched(entities: List<T>)

    fun onError(e: Throwable)

    fun showProgress()

    fun hideProgress()
}