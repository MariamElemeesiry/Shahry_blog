package com.example.shahry_blog.presentation.models

data class Author(
    val id: Long,
    val name: String,
    val userName: String,
    val email: String,
    val avatarUrl: String,
    val address: Address
)
