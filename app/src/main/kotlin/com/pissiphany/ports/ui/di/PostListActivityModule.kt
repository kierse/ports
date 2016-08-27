package com.pissiphany.ports.ui.di

import com.pissiphany.ports.domain.Domain
import com.pissiphany.ports.presenter.PostListPresenter
import com.pissiphany.ports.presenter.PostListPresenterImpl
import dagger.Module
import dagger.Provides
import rx.Scheduler

/**
 * Created by kierse on 2016-08-21.
 */
@Module
class PostListActivityModule {
    @Provides
    fun providePostListPresenter(domain: Domain, scheduler: Scheduler) : PostListPresenter {
        return PostListPresenterImpl(domain, scheduler)
    }
}
