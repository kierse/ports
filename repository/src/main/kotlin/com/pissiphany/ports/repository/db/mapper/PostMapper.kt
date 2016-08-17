package com.pissiphany.ports.repository.db.mapper

import android.content.ContentValues
import android.database.Cursor
import com.pissiphany.ports.domain.model.Post

/**
 * Created by kierse on 2016-08-07.
 */
class PostMapper : ModelMapper<Post> {
    override fun fromCursor(cursor: Cursor): Post {
        // TODO
        return Post()
    }

    override fun toContentValues(obj: Post): ContentValues {
        // TODO
        return ContentValues()
    }
}