package com.example.shahry_blog.domain.repositories

import com.example.shahry_blog.data.DataSourceEnum
import com.example.shahry_blog.data.data_source.local.data_source.LocalAuthorDataSourceImpl
import com.example.shahry_blog.data.data_source.remote.data_source.RemoteAuthorDataSourceImpl
import com.example.shahry_blog.data.entities.mapToDomain
import com.example.shahry_blog.data.repositories.AuthorRepository
import com.example.shahry_blog.domain.entities.AuthorDomain
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class AuthorRepositoryImpl @Inject constructor(
    private val localAuthorDataSourceImpl: LocalAuthorDataSourceImpl,
    private val remoteAuthorDataSourceImpl: RemoteAuthorDataSourceImpl
) : AuthorRepository {
    override fun getAllAuthors(dataSource: DataSourceEnum): Single<List<AuthorDomain>> {
        return when (dataSource) {
            DataSourceEnum.REMOTE -> remoteAuthorDataSourceImpl.getAllAuthors()
                .map { it.mapToDomain() }
            else -> localAuthorDataSourceImpl.getAllAuthors().map { it.mapToDomain() }
        }
    }

    override fun getPostAuthor(dataSource: DataSourceEnum, authorId: Long): Maybe<AuthorDomain> {
        return when (dataSource) {
            DataSourceEnum.REMOTE -> remoteAuthorDataSourceImpl.getPostAuthor(authorId)
                .map { it.mapToDomain() }
            else -> localAuthorDataSourceImpl.getPostAuthor(authorId).map { it.mapToDomain() }
        }
    }
}