package com.example.shahry_blog.domain.repositories

import com.example.shahry_blog.data.data_source.local.data_source.LocalPostsDataSourceImpl
import com.example.shahry_blog.data.data_source.remote.data_source.RemotePostsDataSourceImpl
import com.example.shahry_blog.data.repositories.PostsRepository
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val localPostsDataSourceImpl: LocalPostsDataSourceImpl,
    private val remotePostsDataSourceImpl: RemotePostsDataSourceImpl
) : PostsRepository {

}