package com.pissiphany.ports.domain

import com.pissiphany.ports.domain.model.Comment
import com.pissiphany.ports.domain.model.Post
import org.junit.Test
import rx.Observable
import rx.observers.TestSubscriber

/**
 * Created by kierse on 2016-08-03.
 */
class DomainUnitTest {
    class TestDatabaseService(
            val posts: List<Post>? = listOf(),
            val comments: List<Comment>? = listOf()
    ) : DatabaseService {

        override fun posts() : Observable<List<Post>> {
            return if (posts == null) Observable.empty() else Observable.just(posts)
        }

        override fun comments() : Observable<List<Comment>> {
            return if (comments == null) Observable.empty() else Observable.just(comments)
        }
    }

    class TestJsonPlaceholderService(
            val posts : List<Post>? = listOf(),
            val comments : List<Comment>? = listOf()
    ) : JsonPlaceholderService {
        override fun posts() : Observable<List<Post>> {
            return if (posts == null) Observable.empty() else Observable.just(posts)
        }

        override fun comments() : Observable<List<Comment>> {
            return if (comments == null) Observable.empty() else Observable.just(comments)
        }
    }

    @Test
    fun posts__from_first() {
        val localPosts = listOf(defaultPost())
        val domain = Domain(
                TestDatabaseService(posts = localPosts),
                TestJsonPlaceholderService(posts = listOf(defaultPost().copy(id = 2L)))
        )
        val subscriber = TestSubscriber<List<Post>>()

        domain.posts().subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.assertValue(localPosts)
    }

    @Test
    fun posts__from_second() {
        val remotePosts = listOf(defaultPost().copy(id = 2L))
        val domain = Domain(
                TestDatabaseService(posts = null),
                TestJsonPlaceholderService(posts = remotePosts)
        )
        val subscriber = TestSubscriber<List<Post>>()

        domain.posts().subscribe(subscriber)

        subscriber.assertNoErrors()
        subscriber.assertValue(remotePosts)
    }

    private fun defaultPost() = Post(id = 1L, userId = 1L, title = "title", body = "body")
    private fun defaultComment() = Comment(id = 2L, postId = 2L, email = "email", body = "body")
}