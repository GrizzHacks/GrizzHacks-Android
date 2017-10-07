package com.grizzhacks.grizzhacks.core

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Presenter implementation to show entities.
 */
class EntityPresenterImpl<T>(private var controller: EntityController<T>?, private val interactor: EntityInteractor<T>): EntityPresenter {
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