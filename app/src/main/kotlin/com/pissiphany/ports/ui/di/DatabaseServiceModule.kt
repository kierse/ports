package com.pissiphany.ports.ui.di

import com.pissiphany.ports.domain.DatabaseService
import com.pissiphany.ports.repository.db.MockDatabaseService
import dagger.Module
import dagger.Provides

/**
 * Created by kierse on 2016-08-21.
 */
@Module
class DatabaseServiceModule {
    @Provides
    fun provideDatabaseService() : DatabaseService = MockDatabaseService()
}