package com.example.shahry_blog.domain.usecases

import com.example.shahry_blog.data.DataSourceEnum
import com.example.shahry_blog.domain.entities.mapToPresentation
import com.example.shahry_blog.domain.repositories.CommentsRepositoryImpl
import javax.inject.Inject

class CommentsUseCase @Inject constructor(
    private val commentsRepositoryImpl: CommentsRepositoryImpl
) {
    //TODO:: decide datasource according to network
    fun getCommentsForArticle(articleId: Long) =
        commentsRepositoryImpl.getCommentsForArticle(DataSourceEnum.REMOTE, articleId)
            .map { it.map { it.mapToPresentation() } }
}