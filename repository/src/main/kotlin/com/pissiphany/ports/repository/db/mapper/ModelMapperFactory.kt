package com.pissiphany.ports.repository.db.mapper

import javax.inject.Inject

/**
 * Created by kierse on 2016-08-01.
 */
class ModelMapperFactory @Inject constructor(
        val postMapper: PostMapper,
        val commentMapper: CommentMapper
)
