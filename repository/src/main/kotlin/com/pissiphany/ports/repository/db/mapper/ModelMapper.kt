package com.pissiphany.ports.repository.db.mapper

import android.content.ContentValues
import android.database.Cursor

/**
 * Created by kierse on 2016-08-07.
 */
interface ModelMapper<T> {
    fun fromCursor(cursor: Cursor) : T

    fun allFromCursor(cursor: Cursor) : List<T> {
        val inflated = mutableListOf<T>()
        while (cursor.moveToNext()) {
            inflated.add(fromCursor(cursor))
        }

        return inflated
    }

    fun toContentValues(obj : T) : ContentValues
}