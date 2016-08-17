package com.pissiphany.ports.repository.db

import com.pissiphany.ports.domain.DatabaseService
import com.pissiphany.ports.domain.model.Comment
import com.pissiphany.ports.domain.model.Post
import rx.Observable
import javax.inject.Inject

/**
 * Created by kierse on 2016-08-01.
 */
class MockDatabaseService @Inject constructor(
        val posts: List<Post> = listOf(), val comments: List<Comment> = listOf()
) : DatabaseService {

    override fun posts(): rx.Observable<List<Post>> {
        return if (posts.isEmpty()) Observable.empty() else Observable.just(posts)
    }

    override fun comments(): rx.Observable<List<Comment>> {
        return if (comments.isEmpty()) Observable.empty() else Observable.just(comments)
    }
}