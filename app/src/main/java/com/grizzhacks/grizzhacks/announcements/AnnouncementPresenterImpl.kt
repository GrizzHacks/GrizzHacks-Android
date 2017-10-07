package com.grizzhacks.grizzhacks.announcements

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Presenter that retrieves and handles fetching announcements.
 */
class AnnouncementPresenterImpl(private var controller: AnnouncementController?, private val interactor: AnnouncementInteractor) : AnnouncementPresenter {
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