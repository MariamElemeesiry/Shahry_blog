package com.example.shahry_blog.di

import com.example.shahry_blog.data.data_source.local.data_source.LocalAuthorDataSourceImpl
import com.example.shahry_blog.data.data_source.local.data_source.LocalCommentsDataSourceImpl
import com.example.shahry_blog.data.data_source.local.data_source.LocalPostsDataSourceImpl
import com.example.shahry_blog.data.data_source.local.database.dao.AuthorsDao
import com.example.shahry_blog.data.data_source.local.database.dao.CommentsDao
import com.example.shahry_blog.data.data_source.local.database.dao.PostsDao
import com.example.shahry_blog.data.data_source.remote.ShahryBlogClient
import com.example.shahry_blog.data.data_source.remote.data_source.RemoteAuthorDataSourceImpl
import com.example.shahry_blog.data.data_source.remote.data_source.RemoteCommentsDataSourceImpl
import com.example.shahry_blog.data.data_source.remote.data_source.RemotePostsDataSourceImpl
import com.example.shahry_blog.domain.repositories.AuthorRepositoryImpl
import com.example.shahry_blog.domain.repositories.CommentsRepositoryImpl
import com.example.shahry_blog.domain.repositories.PostsRepositoryImpl
import com.example.shahry_blog.domain.usecases.AuthorsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    //region DataSource
    //region RemoteDataSource
    @Singleton
    @Provides
    fun provideRemoteAuthorDataSource(networkClient: ShahryBlogClient): RemoteAuthorDataSourceImpl =
        RemoteAuthorDataSourceImpl(networkClient)

    @Singleton
    @Provides
    fun provideRemoteCommentsDataSourceImpl(networkClient: ShahryBlogClient): RemoteCommentsDataSourceImpl =
        RemoteCommentsDataSourceImpl(networkClient)

    @Singleton
    @Provides
    fun provideRemotePostsDataSourceImpl(networkClient: ShahryBlogClient): RemotePostsDataSourceImpl =
        RemotePostsDataSourceImpl(networkClient)

    //endregion
    //region LocalDataSource
    @Singleton
    @Provides
    fun provideLocalAuthorDataSource(authorsDao: AuthorsDao): LocalAuthorDataSourceImpl =
        LocalAuthorDataSourceImpl(authorsDao)

    @Singleton
    @Provides
    fun provideLocalCommentsDataSourceImpl(commentsDao: CommentsDao): LocalCommentsDataSourceImpl =
        LocalCommentsDataSourceImpl(commentsDao)

    @Singleton
    @Provides
    fun provideLocalPostsDataSourceImpl(postsDao: PostsDao): LocalPostsDataSourceImpl =
        LocalPostsDataSourceImpl(postsDao)
    //endregion
    //endregion

    //region Repositories
    @Singleton
    @Provides
    fun providePostsRepository(
        localPostsDataSourceImpl: LocalPostsDataSourceImpl,
        remotePostsDataSourceImpl: RemotePostsDataSourceImpl
    ): PostsRepositoryImpl =
        PostsRepositoryImpl(localPostsDataSourceImpl, remotePostsDataSourceImpl)

    @Singleton
    @Provides
    fun provideCommentsRepository(
        localCommentsDataSourceImpl: LocalCommentsDataSourceImpl,
        remoteCommentsDataSourceImpl: RemoteCommentsDataSourceImpl
    ): CommentsRepositoryImpl =
        CommentsRepositoryImpl(localCommentsDataSourceImpl, remoteCommentsDataSourceImpl)

    @Singleton
    @Provides
    fun provideAuthorRepository(
        localAuthorDataSourceImpl: LocalAuthorDataSourceImpl,
        remoteAuthorDataSourceImpl: RemoteAuthorDataSourceImpl
    ): AuthorRepositoryImpl =
        AuthorRepositoryImpl(localAuthorDataSourceImpl, remoteAuthorDataSourceImpl)
    //endregion

    //region UseCases
    @Singleton
    @Provides
    fun provideAuthorsUseCase(
        authorRepositoryImpl: AuthorRepositoryImpl
    ): AuthorsUseCase =
        AuthorsUseCase(authorRepositoryImpl)
    //endregion


}