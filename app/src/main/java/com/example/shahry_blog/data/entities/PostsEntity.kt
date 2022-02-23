package com.example.shahry_blog.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.shahry_blog.domain.entities.PostsDomain
import java.time.OffsetDateTime

@Entity(
    tableName = "posts",
    foreignKeys = [ForeignKey(
        entity = AuthorEntity::class,
        parentColumns = ["id"],
        childColumns = ["authorId"],
        onDelete = ForeignKey.NO_ACTION
    )]
)
data class PostsEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "date") val date: OffsetDateTime,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "body") val body: String?,
    @ColumnInfo(name = "imageUrl") val imageUrl: String?,
    @ColumnInfo(name = "authorId") val authorId:String
)

fun PostsEntity.mapToDomain():PostsDomain = PostsDomain(
    id = id,
    date = date,
    title = title,
    body = body,
    imageUrl = imageUrl,
    author = null,
    commentsList = arrayListOf()
)
