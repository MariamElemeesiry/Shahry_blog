package com.example.shahry_blog.data.data_source

import com.example.shahry_blog.data.entities.AuthorEntity
import io.reactivex.Maybe
import io.reactivex.Single

interface AuthorDataSource {

    fun getAllAuthors(): Single<List<AuthorEntity>>
    fun getPostAuthor(authorId: Long): Maybe<AuthorEntity>

}