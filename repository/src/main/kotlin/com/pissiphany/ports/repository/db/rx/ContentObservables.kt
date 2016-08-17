package com.pissiphany.ports.repository.db.rx

import android.content.ContentResolver
import android.database.Cursor
import android.net.Uri
import rx.Observable
import rx.Subscriber

/**
 * Created by kierse on 2016-08-07.
 *
 * Based on ContentObservables and OnSubscribe* found at:
 * https://github.com/ReactiveX/RxAndroid/commit/f3bcd4f06335c596be32c09ef87c67b0d301e0d5
 *
 * Related:
 * https://github.com/ReactiveX/RxAndroid/pull/147/files
 */
fun fromQuery(
        contentResolver: ContentResolver,
        contentUri: Uri,
        projection: Array<String>? = null,
        selection: String? = null,
        selectionArgs: Array<String>? = null,
        sortOrder: String? = null
) : Observable<Cursor> {
    return Observable.create(OnSubscribeQuery(
            contentResolver, contentUri, projection, selection, selectionArgs, sortOrder
    ))
}

private class OnSubscribeQuery(
        val contentResolver: ContentResolver,
        val contentUri: Uri,
        val projection: Array<String>?,
        val selection: String?,
        val selectionArgs: Array<String>?,
        val sortOrder: String?
) : Observable.OnSubscribe<Cursor> {
    override fun call(subscriber: Subscriber<in Cursor>?) {
        if (subscriber == null) return

        var cursor: Cursor? = null
        try {
            cursor = contentResolver.query(
                    contentUri, projection, selection, selectionArgs, sortOrder
            )

            if (cursor != null) {
                while (cursor.moveToNext()) subscriber.onNext(cursor)
            }
        } finally {
            cursor?.close()
        }

        subscriber.onCompleted()
    }
}
