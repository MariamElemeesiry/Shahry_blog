package com.example.shahry_blog.presentation.models


data class Comments(
    val id: Long,
    val date: String,
    val userName: String?,
    val body: String?,
    val email: String?,
    val avatarUrl: String?
)
