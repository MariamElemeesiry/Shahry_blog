package com.example.shahry_blog.data.data_source.local.data_source

import androidx.paging.PagingSource
import com.example.shahry_blog.data.data_source.PostsDataSource
import com.example.shahry_blog.data.data_source.local.database.dao.PostsDao
import com.example.shahry_blog.data.entities.PostsEntity
import javax.inject.Inject

class LocalPostsDataSourceImpl @Inject constructor(private val postsDao: PostsDao):
    PostsDataSource {
    override fun getAllPosts(page: Int, limit: Int): PagingSource<Int, PostsEntity> =
        postsDao.getAllArticles()
}