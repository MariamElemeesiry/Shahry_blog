package com.example.shahry_blog.domain.usecases

import com.example.shahry_blog.data.DataSourceEnum
import com.example.shahry_blog.domain.entities.mapToPresentation
import com.example.shahry_blog.domain.repositories.PostsRepositoryImpl
import javax.inject.Inject

class ArticlesUseCase @Inject constructor(
    private val postsRepositoryImpl: PostsRepositoryImpl
) {
    //TODO:: decide datasource according to network
    fun getAllArticles() =
        postsRepositoryImpl.getAllPosts(DataSourceEnum.REMOTE, page = 1, limit = 20)
            .mapToPresentation()
}