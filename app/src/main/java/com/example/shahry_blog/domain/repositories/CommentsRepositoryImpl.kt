package com.example.shahry_blog.domain.repositories

import com.example.shahry_blog.data.DataSourceEnum
import com.example.shahry_blog.data.data_source.local.data_source.LocalCommentsDataSourceImpl
import com.example.shahry_blog.data.data_source.remote.data_source.RemoteCommentsDataSourceImpl
import com.example.shahry_blog.data.entities.mapToDomain
import com.example.shahry_blog.data.repositories.CommentsRepository
import com.example.shahry_blog.domain.entities.CommentsDomain
import io.reactivex.Single
import javax.inject.Inject

class CommentsRepositoryImpl @Inject constructor(
    private val localCommentsDataSourceImpl: LocalCommentsDataSourceImpl,
    private val remoteCommentsDataSourceImpl: RemoteCommentsDataSourceImpl
) : CommentsRepository {
    override fun getCommentsForArticle(
        dataSource: DataSourceEnum,
        articleId: Long
    ): Single<List<CommentsDomain>> {
        return when (dataSource) {
            DataSourceEnum.REMOTE -> remoteCommentsDataSourceImpl.getCommentsForArticle(articleId)
                .map { it.mapToDomain() }
            else -> localCommentsDataSourceImpl.getCommentsForArticle(articleId)
                .map { it.mapToDomain() }
        }
    }
}