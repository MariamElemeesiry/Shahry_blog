package com.example.shahry_blog.data.data_source.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.shahry_blog.data.entities.AuthorEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface AuthorsDao : BaseDao<AuthorEntity> {
    @Query("DELETE FROM author")
    fun delete(): Completable

    @Query("SELECT * FROM author")
    fun getAllAuthors(): Single<List<AuthorEntity>>

    @Query("SELECT * FROM author WHERE id = :authorId")
    fun getAllAuthorsPosts(authorId: Long): Maybe<AuthorEntity>
}