package com.example.shahry_blog.domain.entities

import com.example.shahry_blog.presentation.models.Author

data class AuthorDomain(
    val id: Long,
    val name: String,
    val userName: String,
    val email: String,
    val avatarUrl: String,
    val addressDomain: AddressDomain
)

fun AuthorDomain.mapToPresentation(): Author = Author(
    id = id,
    name = name,
    userName = userName,
    email = email,
    avatarUrl = avatarUrl,
    address = addressDomain.mapToPresentation()
)


