package com.pissiphany.ports.presenter

import com.pissiphany.ports.domain.model.Post

/**
 * Created by kierse on 2016-08-21.
 */
interface PostListView {
    fun addPosts(posts: List<Post>)
    fun lastPost() : Post
    fun firstPost() : Post
    fun displayMessage(message: String)
}