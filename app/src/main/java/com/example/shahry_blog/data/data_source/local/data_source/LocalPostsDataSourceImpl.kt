package com.example.shahry_blog.data.data_source.local.data_source

import com.example.shahry_blog.data.data_source.PostsDataSource
import com.example.shahry_blog.data.data_source.local.database.dao.PostsDao
import javax.inject.Inject

class LocalPostsDataSourceImpl @Inject constructor(private val postsDao: PostsDao):
    PostsDataSource {
}