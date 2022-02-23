package com.example.shahry_blog.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.shahry_blog.domain.entities.CommentsDomain
import java.time.OffsetDateTime

@Entity(
    tableName = "posts",
    foreignKeys = [ForeignKey(
        entity = PostsEntity::class,
        parentColumns = ["id"],
        childColumns = ["postId"],
        onDelete = ForeignKey.NO_ACTION
    )]
)
data class CommentsEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "date") val date: OffsetDateTime,
    @ColumnInfo(name = "userName") val userName: String?,
    @ColumnInfo(name = "body") val body: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "avatarUrl") val avatarUrl: String?,
    @ColumnInfo(name = "postId") val postId:String
)

fun CommentsEntity.mapToDomain():CommentsDomain = CommentsDomain(
    id= id,
    userName = userName,
    date = date,
    body = body,
    email = email,
    avatarUrl = avatarUrl
)
