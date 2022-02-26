package com.example.shahry_blog.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.shahry_blog.domain.entities.AddressDomain
import com.example.shahry_blog.domain.entities.AuthorDomain

@Entity(tableName = "author")
data class AuthorEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "userName") val userName: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "avatarUrl") val avatarUrl: String,
    @ColumnInfo(name = "latitude") val latitude: Double,
    @ColumnInfo(name = "longitude") val longitude: Double
)

fun AuthorEntity.mapToDomain(): AuthorDomain = AuthorDomain(
    id = id,
    name = name,
    userName = userName,
    email = email,
    avatarUrl = avatarUrl,
    addressDomain = AddressDomain(latitude, longitude)
)

fun List<AuthorEntity>.mapToDomain(): List<AuthorDomain> = map { it.mapToDomain() }


