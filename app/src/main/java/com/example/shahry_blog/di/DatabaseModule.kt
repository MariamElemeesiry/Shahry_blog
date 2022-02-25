package com.example.shahry_blog.di

import android.content.Context
import com.example.shahry_blog.data.data_source.local.database.BlogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule{

    @Provides
    @Singleton
    fun getDatabase(context: Context): BlogDatabase = BlogDatabase.getDatabaseInstance(context)

    @Provides
    @Singleton
    fun providePostsDao(blogDatabase: BlogDatabase) = blogDatabase.postsDao()

    @Provides
    @Singleton
    fun provideAuthorDao(blogDatabase: BlogDatabase) = blogDatabase.authorsDao()

    @Provides
    @Singleton
    fun provideCommentsDao(blogDatabase: BlogDatabase) = blogDatabase.commentsDao()



}