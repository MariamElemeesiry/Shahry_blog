package com.example.shahry_blog.data.data_source.remote.data_source

import com.example.shahry_blog.data.data_source.PostsDataSource
import com.example.shahry_blog.data.data_source.remote.ShahryBlogClient
import javax.inject.Inject

class RemotePostsDataSourceImpl @Inject constructor(private val networkClient: ShahryBlogClient):
    PostsDataSource {
}