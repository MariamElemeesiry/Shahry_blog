package com.example.shahry_blog.domain.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.shahry_blog.data.DataSourceEnum
import com.example.shahry_blog.data.data_source.local.data_source.LocalPostsDataSourceImpl
import com.example.shahry_blog.data.data_source.remote.data_source.RemotePostsDataSourceImpl
import com.example.shahry_blog.data.entities.mapToDomain
import com.example.shahry_blog.data.repositories.PostsRepository
import com.example.shahry_blog.domain.entities.PostsDomain
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val localPostsDataSourceImpl: LocalPostsDataSourceImpl,
    private val remotePostsDataSourceImpl: RemotePostsDataSourceImpl
) : PostsRepository {
    override fun getAllPosts(
        dataSource: DataSourceEnum,
        page: Int,
        limit: Int
    ): Flow<PagingData<PostsDomain>> {
        return when (dataSource) {
            DataSourceEnum.REMOTE -> {
                Pager(
                    config = PagingConfig(
                        pageSize = 20,
                        maxSize = 100,
                        enablePlaceholders = false
                    ),
                    pagingSourceFactory = { remotePostsDataSourceImpl.getAllPosts(page, limit) }
                ).flow.mapToDomain()

            }
            else -> {
                Pager(
                    config = PagingConfig(
                        pageSize = 20,
                        maxSize = 100,
                        enablePlaceholders = false
                    ),
                    pagingSourceFactory = { localPostsDataSourceImpl.getAllPosts(page, limit) }
                ).flow.mapToDomain()
            }
        }
    }

}