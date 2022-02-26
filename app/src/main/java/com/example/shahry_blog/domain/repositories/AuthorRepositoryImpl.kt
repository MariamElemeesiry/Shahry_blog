package com.example.shahry_blog.domain.repositories

import com.example.shahry_blog.data.DataSourceEnum
import com.example.shahry_blog.data.data_source.local.data_source.LocalAuthorDataSourceImpl
import com.example.shahry_blog.data.data_source.remote.data_source.RemoteAuthorDataSourceImpl
import com.example.shahry_blog.data.entities.mapToDomain
import com.example.shahry_blog.data.repositories.AuthorRepository
import com.example.shahry_blog.domain.entities.AuthorDomain
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
}