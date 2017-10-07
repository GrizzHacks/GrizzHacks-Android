package com.grizzhacks.grizzhacks.core

import io.reactivex.Flowable


/**
 * Retrieves a list of entities from the database and/or server.
 */
interface EntityInteractor<T> {
    fun fetch(): Flowable<List<T>>
}