package com.example.shahry_blog.data.data_source

import com.example.shahry_blog.data.entities.CommentsEntity
import io.reactivex.Single

interface CommentsDataSource {
    fun getCommentsForArticle(articleId: Long): Single<List<CommentsEntity>>

}