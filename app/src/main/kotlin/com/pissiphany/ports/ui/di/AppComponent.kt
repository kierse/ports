package com.pissiphany.ports.ui.di

import android.content.Context
import com.pissiphany.ports.domain.DatabaseService
import com.pissiphany.ports.domain.JsonPlaceholderService
import com.pissiphany.ports.ui.App
import dagger.Component
import rx.Scheduler

/**
 * Created by kierse on 2016-08-21.
 */
@Component(modules = arrayOf(
        AppModule::class,
        JsonPlaceholderServiceModule::class,
        DatabaseServiceModule::class
))
interface AppComponent {
    fun app() : App
    fun context() : Context
    fun scheduler() : Scheduler

    fun jsonPlaceholderService() : JsonPlaceholderService
    fun databaseService() : DatabaseService
}
