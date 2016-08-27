package com.pissiphany.ports.ui.di

import com.pissiphany.ports.presenter.PostListPresenter
import com.pissiphany.ports.ui.posts.PostListActivity
import dagger.Component
import rx.Scheduler

/**
 * Created by kierse on 2016-08-21.
 */
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(PostListActivityModule::class)
)
interface PostListActivityComponent {
    fun presenter() : PostListPresenter
    fun scheduler() : Scheduler

    fun inject(activity: PostListActivity)
}