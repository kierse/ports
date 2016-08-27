package com.pissiphany.ports.ui

import android.app.Application
import com.pissiphany.ports.ui.di.*
import rx.android.schedulers.AndroidSchedulers

/**
 * Created by kierse on 2016-08-21.
 */
class App : Application(), HasComponent<AppComponent> {
    override val component: AppComponent =
            DaggerAppComponent
                    .builder()
                    .appModule(AppModule(this, AndroidSchedulers.mainThread()))
                    .jsonPlaceholderServiceModule(JsonPlaceholderServiceModule())
                    .databaseServiceModule(DatabaseServiceModule())
                    .build()
}