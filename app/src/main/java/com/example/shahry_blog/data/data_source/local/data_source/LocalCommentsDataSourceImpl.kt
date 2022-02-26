package com.example.shahry_blog.data.data_source.local.data_source

import com.example.shahry_blog.data.data_source.CommentsDataSource
import com.example.shahry_blog.data.data_source.local.database.dao.CommentsDao
import com.example.shahry_blog.data.entities.CommentsEntity
import io.reactivex.Single
import javax.inject.Inject

class LocalCommentsDataSourceImpl @Inject constructor(private val commentsDao: CommentsDao) :
    CommentsDataSource {
    override fun getCommentsForArticle(articleId: Long): Single<List<CommentsEntity>> {
        TODO("Not yet implemented")
    }

}