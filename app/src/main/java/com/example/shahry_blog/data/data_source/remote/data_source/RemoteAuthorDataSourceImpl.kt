package com.example.shahry_blog.data.data_source.remote.data_source

import com.example.shahry_blog.data.data_source.AuthorDataSource
import com.example.shahry_blog.data.data_source.local.database.dao.AuthorsDao
import com.example.shahry_blog.data.data_source.remote.ShahryBlogClient
import com.example.shahry_blog.data.entities.AuthorEntity
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class RemoteAuthorDataSourceImpl @Inject constructor(
    private val networkClient: ShahryBlogClient,
    private val authorsDao: AuthorsDao
) : AuthorDataSource {
    override fun getAllAuthors(): Single<List<AuthorEntity>> =
        networkClient.getAllAuthors().map {
            authorsDao.insertOrUpdateAll(it).subscribe()
            it
        }

    override fun getPostAuthor(authorId: Long): Maybe<AuthorEntity> =
        networkClient.getPostAuthor(authorId).map {
            authorsDao.insertOrUpdate(it).subscribe()
            it
        }
}