package com.pissiphany.ports.repository.jsonPlaceholder

import com.google.gson.Gson
import com.pissiphany.ports.domain.model.Post
import org.junit.Test
import rx.Observable
import rx.observers.TestSubscriber
import kotlin.test.assertEquals

/**
 * Created by kierse on 2016-08-07.
 */
class JsonPlaceholderServiceUnitTest {
    @Test
    fun posts() {
        val subscriber = TestSubscriber<Post>()

        buildJsonPlaceholderService()
                .posts()
                .flatMap { Observable.from(it) }
                .subscribe(subscriber)

        subscriber.assertCompleted()
        subscriber.assertNoErrors()
        assertEquals(100, subscriber.valueCount)
    }

    @Test
    fun posts__json_to_object() {
        val userId = 1L
        val id = 2L
        val title = "title"
        val body = "body"
        val json = "{userId:${userId},id:${id},title:${title},body:${body}}"

        val expected = Post(
                userId = userId,
                id = id,
                title = title,
                body = body
        )
        val gson = Gson()

        assertEquals(expected, gson.fromJson(json, Post::class.java))
    }
}