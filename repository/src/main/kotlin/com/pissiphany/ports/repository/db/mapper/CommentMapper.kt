package com.pissiphany.ports.repository.db.mapper

import android.content.ContentValues
import android.database.Cursor
import com.pissiphany.ports.domain.model.Comment

/**
 * Created by kierse on 2016-08-09.
 */
class CommentMapper : ModelMapper<Comment> {
    override fun fromCursor(cursor: Cursor): Comment {
        // TODO
        return Comment()
    }

    override fun toContentValues(obj: Comment): ContentValues {
        return ContentValues()
    }
}