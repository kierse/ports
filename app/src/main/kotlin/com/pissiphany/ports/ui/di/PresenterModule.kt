package com.pissiphany.ports.ui.di

import dagger.Module
import dagger.Provides
import rx.Scheduler

/**
 * Created by kierse on 2016-08-21.
 */
@Module
class PresenterModule(private val scheduler: Scheduler) {
    @Provides
    fun provideScheduler() : Scheduler = scheduler
}