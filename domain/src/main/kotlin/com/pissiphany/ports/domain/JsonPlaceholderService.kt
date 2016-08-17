package com.pissiphany.ports.domain

import com.pissiphany.ports.domain.model.Comment
import com.pissiphany.ports.domain.model.Post
import retrofit2.http.GET
import rx.Observable

/**
 * Created by kierse on 2016-08-01.
 */

interface JsonPlaceholderService {
    @GET("posts")
    fun posts() : Observable<List<Post>>

    @GET("comments")
    fun comments(): Observable<List<Comment>>
}
