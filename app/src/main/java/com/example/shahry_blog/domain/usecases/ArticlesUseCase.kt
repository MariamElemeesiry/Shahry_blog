package com.example.shahry_blog.domain.usecases

import android.content.Context
import androidx.paging.PagingData
import com.example.shahry_blog.data.DataSourceEnum
import com.example.shahry_blog.domain.entities.mapToPresentation
import com.example.shahry_blog.domain.repositories.PostsRepositoryImpl
import com.example.shahry_blog.helpers.checkServerAndInternetConnection
import com.example.shahry_blog.presentation.models.Articles
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticlesUseCase @Inject constructor(
    private val postsRepositoryImpl: PostsRepositoryImpl,
    private val context: Context
) {
    //TODO:: decide datasource according to network
    fun getAllArticles(): Flow<PagingData<Articles>> {
        val hasNet =
            checkServerAndInternetConnection(context = context).subscribeOn(Schedulers.io())
                .blockingGet()
        return postsRepositoryImpl.getAllPosts(
            if (hasNet) DataSourceEnum.REMOTE else DataSourceEnum.ROOM_DB,
            page = 1,
            limit = 20
        )
            .mapToPresentation()
    }

    fun getAuthorArticles(authorId: Long): Flow<PagingData<Articles>> {
        val hasNet =
            checkServerAndInternetConnection(context = context).subscribeOn(Schedulers.io())
                .blockingGet()
        return postsRepositoryImpl.getAuthorArticles(
            if (hasNet) DataSourceEnum.REMOTE else DataSourceEnum.ROOM_DB,
            page = 1,
            limit = 20,
            authorId
        )
            .mapToPresentation()
    }

}