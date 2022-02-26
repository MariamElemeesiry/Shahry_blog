package com.example.shahry_blog.domain.usecases

import com.example.shahry_blog.data.DataSourceEnum
import com.example.shahry_blog.domain.entities.mapToPresentation
import com.example.shahry_blog.domain.repositories.AuthorRepositoryImpl
import javax.inject.Inject

class AuthorsUseCase @Inject constructor(
    private val authorRepositoryImpl: AuthorRepositoryImpl
) {
    //TODO:: decide datasource according to network
    fun getAllAuthors() = authorRepositoryImpl.getAllAuthors(DataSourceEnum.REMOTE)
        .map { it.map { it.mapToPresentation() } }
}