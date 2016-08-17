package com.pissiphany.ports.repository.db.contract

import android.net.Uri

/**
 * Created by kierse on 2016-08-09.
 */
class CommentContract private constructor() {
    companion object {
        val CONTENT_URI : Uri = Uri.EMPTY
    }

    class Columns private constructor() {
        companion object {
            val COLUMN_A = "col_a"
            val COLUMN_B = "col_b"
            val COLUMN_C = "col_c"
        }
    }
}