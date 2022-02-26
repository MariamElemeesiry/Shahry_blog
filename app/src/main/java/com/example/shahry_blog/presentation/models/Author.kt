package com.example.shahry_blog.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Author(
    val id: Long,
    val name: String,
    val userName: String,
    val email: String,
    val avatarUrl: String,
    val address: Address
) : Parcelable
