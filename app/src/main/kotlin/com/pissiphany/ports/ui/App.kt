package com.pissiphany.ports.ui

import android.app.Application
import com.pissiphany.ports.ui.di.AppComponent
import com.pissiphany.ports.ui.di.AppModule
import com.pissiphany.ports.ui.di.DaggerAppComponent
import com.pissiphany.ports.ui.di.HasComponent

/**
 * Created by kierse on 2016-08-21.
 */
class App : Application(), HasComponent<AppComponent> {
    override val component: AppComponent =
            DaggerAppComponent
                    .builder()
                    .appModule(AppModule(this))
                    .build()
}