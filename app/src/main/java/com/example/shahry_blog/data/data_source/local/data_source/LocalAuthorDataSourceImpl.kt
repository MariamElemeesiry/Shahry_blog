package com.example.shahry_blog.data.data_source.local.data_source

import com.example.shahry_blog.data.data_source.AuthorDataSource
import com.example.shahry_blog.data.data_source.local.database.dao.AuthorsDao
import javax.inject.Inject

class LocalAuthorDataSourceImpl @Inject constructor(private val authorsDao: AuthorsDao):AuthorDataSource {
    override fun getAllAuthors() = authorsDao.getAllAuthors()

    override fun getPostAuthor(authorId: Long) = authorsDao.getAllAuthorsPosts(authorId)
}