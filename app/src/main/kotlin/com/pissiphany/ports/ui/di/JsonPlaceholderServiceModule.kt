package com.pissiphany.ports.ui.di

import com.pissiphany.ports.domain.JsonPlaceholderService
import com.pissiphany.ports.repository.jsonPlaceholder.buildJsonPlaceholderService
import dagger.Module
import dagger.Provides

/**
 * Created by kierse on 2016-08-21.
 */
@Module
class JsonPlaceholderServiceModule {
    @Provides
    fun provideJsonPlaceholderService() : JsonPlaceholderService = buildJsonPlaceholderService()
}