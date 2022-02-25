package com.example.shahry_blog.data.data_source

import com.example.shahry_blog.data.entities.AuthorEntity
import io.reactivex.Single

interface AuthorDataSource {

   fun getAllAuthors(): Single<List<AuthorEntity>>
}