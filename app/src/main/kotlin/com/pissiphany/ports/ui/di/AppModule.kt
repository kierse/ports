package com.pissiphany.ports.ui.di

import android.content.Context
import com.pissiphany.ports.ui.App
import dagger.Module
import dagger.Provides
import rx.Scheduler

/**
 * Created by kierse on 2016-08-09.
 */
@Module
class AppModule(private val app: App, private val scheduler: Scheduler) {
    @Provides
    fun provideApp() : App = app

    @Provides
    fun provideContext() : Context = app.applicationContext

    @Provides
    fun provideScheduler() : Scheduler = scheduler
}