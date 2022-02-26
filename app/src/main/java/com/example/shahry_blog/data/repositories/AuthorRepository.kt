package com.example.shahry_blog.data.repositories

import com.example.shahry_blog.data.DataSourceEnum
import com.example.shahry_blog.domain.entities.AuthorDomain
import io.reactivex.Single

interface AuthorRepository {
    fun getAllAuthors(dataSource: DataSourceEnum): Single<List<AuthorDomain>>
}