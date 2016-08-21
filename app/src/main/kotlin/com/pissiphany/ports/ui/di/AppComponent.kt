package com.pissiphany.ports.ui.di

import com.pissiphany.ports.ui.App
import dagger.Component

/**
 * Created by kierse on 2016-08-21.
 */
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun app() : App
}