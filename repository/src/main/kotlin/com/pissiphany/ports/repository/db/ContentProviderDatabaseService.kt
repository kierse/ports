package com.pissiphany.ports.repository.db

import android.content.Context
import com.pissiphany.ports.domain.DatabaseService
import com.pissiphany.ports.domain.annotation.ForApplication
import com.pissiphany.ports.domain.model.Comment
import com.pissiphany.ports.domain.model.Post
import com.pissiphany.ports.repository.db.contract.CommentContract
import com.pissiphany.ports.repository.db.contract.PostContract
import com.pissiphany.ports.repository.db.mapper.ModelMapperFactory
import com.pissiphany.ports.repository.db.rx.fromQuery
import javax.inject.Inject

/**
 * Created by kierse on 2016-08-01.
 */
class ContentProviderDatabaseService @Inject constructor(
        @ForApplication val context: Context, val mapperFactory: ModelMapperFactory
) : DatabaseService {

    override fun posts(): rx.Observable<List<Post>> {
        return fromQuery(
                context.contentResolver,
                PostContract.Companion.CONTENT_URI,
                arrayOf(
                        PostContract.Columns.Companion.COLUMN_A,
                        PostContract.Columns.Companion.COLUMN_B,
                        PostContract.Columns.Companion.COLUMN_C
                )
        )
        .map { cursor -> mapperFactory.postMapper.fromCursor(cursor) }
        .toList()
        // TODO probably need to specify thread to do work on
    }

    override fun comments(): rx.Observable<List<Comment>> {
        return fromQuery(
                context.contentResolver,
                CommentContract.Companion.CONTENT_URI,
                arrayOf(
                        CommentContract.Columns.Companion.COLUMN_A,
                        CommentContract.Columns.Companion.COLUMN_B,
                        CommentContract.Columns.Companion.COLUMN_C
                )
        )
        .map { cursor -> mapperFactory.commentMapper.fromCursor(cursor) }
        .toList()
    }
}