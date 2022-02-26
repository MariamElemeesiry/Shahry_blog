package com.example.shahry_blog.data.repositories

import com.example.shahry_blog.data.DataSourceEnum
import com.example.shahry_blog.domain.entities.CommentsDomain
import io.reactivex.Single

interface CommentsRepository {
    fun getCommentsForArticle(
        dataSource: DataSourceEnum,
        articleId: Long
    ): Single<List<CommentsDomain>>

}