package com.grizzhacks.grizzhacks.events

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Presenter that retrieves and handles fetching announcements.
 */
class EventPresenterImpl(private var controller: EventController?, private val interactor: EventInteractor) : EventPresenter {
    override fun fetch() {
        controller?.showProgress()
        interactor.fetch()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            controller?.hideProgress()
                            controller?.onFetched(it)
                        },
                        {
                            controller?.hideProgress()
                            controller?.onError(it)
                        })
    }

    override fun onDestroy() {
        controller = null
    }
}