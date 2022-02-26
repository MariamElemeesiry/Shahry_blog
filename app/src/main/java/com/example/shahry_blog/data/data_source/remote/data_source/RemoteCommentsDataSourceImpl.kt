package com.example.shahry_blog.data.data_source.remote.data_source

import com.example.shahry_blog.data.data_source.CommentsDataSource
import com.example.shahry_blog.data.data_source.remote.ShahryBlogClient
import com.example.shahry_blog.data.entities.CommentsEntity
import io.reactivex.Single
import javax.inject.Inject

class RemoteCommentsDataSourceImpl @Inject constructor(private val networkClient: ShahryBlogClient) :
    CommentsDataSource {
    override fun getCommentsForArticle(articleId: Long): Single<List<CommentsEntity>> =
        networkClient.getCommentsForPost(articleId).map { it.body() }

}