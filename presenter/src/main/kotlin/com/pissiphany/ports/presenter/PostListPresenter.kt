package com.pissiphany.ports.presenter

/**
 * Created by kierse on 2016-08-21.
 */
interface PostListPresenter {
    fun onResume(view: PostListView)
    fun onPause()
    fun bottomOfList()
    fun topOfList()
}