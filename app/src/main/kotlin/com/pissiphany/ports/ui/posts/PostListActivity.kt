package com.pissiphany.ports.ui.posts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.pissiphany.ports.domain.Domain
import com.pissiphany.ports.domain.model.Post
import com.pissiphany.ports.ui.R
import com.pissiphany.ports.ui.di.DaggerPostListActivityComponent
import com.pissiphany.ports.ui.di.DatabaseServiceModule
import com.pissiphany.ports.ui.di.JsonPlaceholderServiceModule
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

class PostListActivity : AppCompatActivity() {
    val subscriptions = CompositeSubscription()
    lateinit var listView: ListView
    lateinit var adapter: PostListAdapter

    @Inject lateinit var domain: Domain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerPostListActivityComponent
                .builder()
                .databaseServiceModule(DatabaseServiceModule())
                .jsonPlaceholderServiceModule(JsonPlaceholderServiceModule())
                .build()
                .inject(this)

        setContentView(R.layout.activity_post_list)

        adapter = PostListAdapter(this, R.layout.activity_post_list_item)
        listView = findViewById(R.id.list) as ListView
        listView.adapter = adapter

        if (savedInstanceState == null) {
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
