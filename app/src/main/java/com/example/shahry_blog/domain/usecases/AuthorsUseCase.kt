package com.example.shahry_blog.domain.usecases

import android.content.Context
import com.example.shahry_blog.data.DataSourceEnum
import com.example.shahry_blog.domain.entities.mapToPresentation
import com.example.shahry_blog.domain.repositories.AuthorRepositoryImpl
import com.example.shahry_blog.helpers.checkServerAndInternetConnection
import com.example.shahry_blog.presentation.models.Author
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthorsUseCase @Inject constructor(
    private val authorRepositoryImpl: AuthorRepositoryImpl,
    private val context: Context
) {
    //TODO:: decide datasource according to network
    fun getAllAuthors(): Single<List<Author>> {
        val hasNet =
            checkServerAndInternetConnection(context = context).subscribeOn(Schedulers.io())
                .blockingGet()
        return authorRepositoryImpl.getAllAuthors(if (hasNet) DataSourceEnum.REMOTE else DataSourceEnum.ROOM_DB)
            .map { it.map { it.mapToPresentation() } }
    }

    fun getPostAuthor(authorId: Long): Maybe<Author> {
        val hasNet =
            checkServerAndInternetConnection(context = context).subscribeOn(Schedulers.io())
                .blockingGet()
        return authorRepositoryImpl.getPostAuthor(
            if (hasNet) DataSourceEnum.REMOTE else DataSourceEnum.ROOM_DB,
            authorId
        )
            .map { it.mapToPresentation() }
    }
}