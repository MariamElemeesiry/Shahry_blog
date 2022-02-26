package com.example.shahry_blog.data.data_source.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.shahry_blog.data.entities.CommentsEntity
import io.reactivex.Completable

@Dao
interface CommentsDao : BaseDao<CommentsEntity> {
    @Query("DELETE FROM comments")
    fun delete(): Completable
}