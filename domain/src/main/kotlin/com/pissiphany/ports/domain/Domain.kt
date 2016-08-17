package com.pissiphany.ports.domain

import com.pissiphany.ports.domain.model.Comment
import com.pissiphany.ports.domain.model.Post
import rx.Observable
import javax.inject.Inject

/**
 * Created by kierse on 2016-08-01.
 */
class Domain @Inject constructor(
        val dbService: DatabaseService, val webService: JsonPlaceholderService
) {
    fun posts() : Observable<List<Post>> {
        return Observable.concat(dbService.posts(), webService.posts()).first()
    }

    fun comments() : Observable<List<Comment>> {
        return Observable.concat(dbService.comments(), webService.comments()).first()
    }
}