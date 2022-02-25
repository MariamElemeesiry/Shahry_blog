package com.example.shahry_blog.domain.repositories

import com.example.shahry_blog.data.data_source.local.data_source.LocalCommentsDataSourceImpl
import com.example.shahry_blog.data.data_source.remote.data_source.RemoteCommentsDataSourceImpl
import com.example.shahry_blog.data.repositories.CommentsRepository
import javax.inject.Inject

class CommentsRepositoryImpl @Inject constructor(
    private val localCommentsDataSourceImpl: LocalCommentsDataSourceImpl,
    private val remoteCommentsDataSourceImpl: RemoteCommentsDataSourceImpl
) : CommentsRepository {
}