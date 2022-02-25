package com.example.shahry_blog.domain.repositories

import com.example.shahry_blog.data.data_source.local.data_source.LocalAuthorDataSourceImpl
import com.example.shahry_blog.data.data_source.remote.data_source.RemoteAuthorDataSourceImpl
import com.example.shahry_blog.data.repositories.AuthorRepository
import javax.inject.Inject

class AuthorRepositoryImpl @Inject constructor(
    private val localAuthorDataSourceImpl: LocalAuthorDataSourceImpl,
    private val remoteAuthorDataSourceImpl: RemoteAuthorDataSourceImpl
) : AuthorRepository {
}