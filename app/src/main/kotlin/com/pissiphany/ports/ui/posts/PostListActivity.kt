package com.pissiphany.ports.ui.posts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.pissiphany.ports.domain.Domain
import com.pissiphany.ports.domain.model.Post
import com.pissiphany.ports.repository.db.MockDatabaseService
import com.pissiphany.ports.repository.jsonPlaceholder.buildJsonPlaceholderService
import com.pissiphany.ports.ui.R
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

class PostListActivity : AppCompatActivity() {
    val subscriptions = CompositeSubscription()
    lateinit var listView: ListView
    lateinit var adapter: PostListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)

        adapter = PostListAdapter(this, R.layout.activity_post_list_item)
        listView = findViewById(R.id.list) as ListView
        listView.adapter = adapter

        if (savedInstanceState == null) {
            val domain = Domain(MockDatabaseService(), buildJsonPlaceholderService())
            subscriptions.add(domain.posts()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        setPosts(it)
                    }, {
                        Log.e("blah", it.message)
                    })
            )
        }
    }

    override fun onStop() {
        super.onStop()
        subscriptions.unsubscribe()
    }

    private fun setPosts(posts : List<Post>) {
        adapter.addAll(posts)
    }
}
