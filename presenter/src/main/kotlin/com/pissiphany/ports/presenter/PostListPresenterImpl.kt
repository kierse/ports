package com.pissiphany.ports.presenter

import com.pissiphany.ports.domain.Domain
import rx.Scheduler
import rx.Subscription
import rx.schedulers.Schedulers

/**
 * Created by kierse on 2016-08-21.
 */
class PostListPresenterImpl(private val domain: Domain, private val mainThread: Scheduler)
: PostListPresenter {
    var view: PostListView? = null

    var subscription: Subscription? = null
    var observable = domain.posts()
                           .subscribeOn(Schedulers.io())
                           .observeOn(mainThread)

    override fun onResume(v: PostListView) {
        this.view = v

        subscription = observable.subscribe(
                { view?.addPosts(it) }, // onNext
                { /* TODO handle errors */ }  // onError
        )
    }

    override fun onPause() {
        view = null
        subscription?.unsubscribe()
    }

    override fun bottomOfList() {
        view?.displayMessage(
                "Last Post has ID ${view?.lastPost()?.id}"
        )
    }

    override fun topOfList() { }
}
