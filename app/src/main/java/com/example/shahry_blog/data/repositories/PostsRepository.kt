package com.example.shahry_blog.data.repositories

import androidx.paging.PagingData
import com.example.shahry_blog.data.DataSourceEnum
import com.example.shahry_blog.domain.entities.PostsDomain
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    fun getAllPosts(
        dataSource: DataSourceEnum,
        page: Int,
        limit: Int
    ): Flow<PagingData<PostsDomain>>
}