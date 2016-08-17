package com.pissiphany.ports.domain

import com.pissiphany.ports.domain.model.Comment
import com.pissiphany.ports.domain.model.Post
import rx.Observable

interface DatabaseService {
    fun posts() : Observable<List<Post>>
    fun comments() : Observable<List<Comment>>
}
