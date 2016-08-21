package com.pissiphany.ports.ui.di

import com.pissiphany.ports.domain.Domain
import com.pissiphany.ports.ui.posts.PostListActivity
import dagger.Component

/**
 * Created by kierse on 2016-08-21.
 */
@Component(modules = arrayOf(
        JsonPlaceholderServiceModule::class,
        DatabaseServiceModule::class
))
interface PostListActivityComponent {
    fun domain() : Domain

    fun inject(activity: PostListActivity)
}