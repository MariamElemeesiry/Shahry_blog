package com.example.shahry_blog.data.data_source.remote.data_source

import com.example.shahry_blog.data.data_source.AuthorDataSource
import com.example.shahry_blog.data.data_source.remote.ShahryBlogClient
import com.example.shahry_blog.data.entities.AuthorEntity
import io.reactivex.Single
import javax.inject.Inject

class RemoteAuthorDataSourceImpl @Inject constructor(private val networkClient: ShahryBlogClient):AuthorDataSource {
    override fun getAllAuthors(): Single<List<AuthorEntity>> = networkClient.getAllAuthors().map { it.body() }
}