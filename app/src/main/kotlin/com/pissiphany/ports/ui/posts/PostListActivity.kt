package com.pissiphany.ports.ui.posts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView
import android.widget.ListView
import android.widget.Toast
import com.pissiphany.ports.domain.model.Post
import com.pissiphany.ports.presenter.PostListPresenter
import com.pissiphany.ports.presenter.PostListView
import com.pissiphany.ports.ui.App
import com.pissiphany.ports.ui.R
import com.pissiphany.ports.ui.di.*

class PostListActivity : AppCompatActivity(), AbsListView.OnScrollListener, PostListView {
    lateinit var listView: ListView
    lateinit var adapter: PostListAdapter
    lateinit var presenter: PostListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_post_list)

        if (savedInstanceState == null) {
            presenter = DaggerPostListActivityComponent
                    .builder()
                    .appComponent((application as App).component)
                    .postListActivityModule(PostListActivityModule())
                    .build()
                    .presenter()
        } else {
            presenter = lastCustomNonConfigurationInstance as PostListPresenter
        }

        adapter = PostListAdapter(this, R.layout.activity_post_list_item)
        listView = findViewById(R.id.list) as ListView
        listView.adapter = adapter
        listView.setOnScrollListener(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onRetainCustomNonConfigurationInstance(): Any = presenter

    override fun addPosts(posts: List<Post>) {
        adapter.addAll(posts)
    }

    override fun lastPost(): Post = adapter.getItem(adapter.count - 1)

    override fun firstPost(): Post = adapter.getItem(0)

    override fun displayMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onScroll(view: AbsListView?, firstVisible: Int, visibleCount: Int, totalItemCount: Int) {
        if (adapter.count == 0) return

        when (view?.id) {
            R.id.list -> {
                if (firstVisible + visibleCount == totalItemCount) {
                    presenter.bottomOfList()
                }
            }
        }
    }

    override fun onScrollStateChanged(p0: AbsListView?, p1: Int) { }
}
