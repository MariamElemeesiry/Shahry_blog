package com.example.shahry_blog.data.data_source.local.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.example.shahry_blog.data.entities.PostsEntity
import io.reactivex.Completable


@Dao
interface PostsDao : BaseDao<PostsEntity> {
    @Query("DELETE FROM posts")
    fun delete(): Completable

    @Query("SELECT * FROM posts")
    fun getAllArticles(): PagingSource<Int, PostsEntity>
}