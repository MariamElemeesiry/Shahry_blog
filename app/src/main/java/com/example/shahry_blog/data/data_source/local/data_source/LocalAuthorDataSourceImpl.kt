package com.example.shahry_blog.data.data_source.local.data_source

import com.example.shahry_blog.data.data_source.AuthorDataSource
import com.example.shahry_blog.data.data_source.local.database.dao.AuthorsDao
import com.example.shahry_blog.data.entities.AuthorEntity
import io.reactivex.Single
import javax.inject.Inject

class LocalAuthorDataSourceImpl @Inject constructor(private val authorsDao: AuthorsDao):AuthorDataSource {
    override fun getAllAuthors(): Single<List<AuthorEntity>> {
        TODO("Not yet implemented")
    }
}