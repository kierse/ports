package com.pissiphany.ports.ui.di

import android.content.Context
import com.pissiphany.ports.domain.annotation.ForApplication
import com.pissiphany.ports.ui.App
import dagger.Module
import dagger.Provides

/**
 * Created by kierse on 2016-08-09.
 */
@Module
class AppModule(app: App) {
    private val app: App = app

    @Provides
    fun provideApp() : App = app

    @Provides
    @ForApplication
    fun provideContext() : Context = app.applicationContext
}