package com.example.shahry_blog.helpers

data class Resource<T> constructor(
    val state: ResourceState?,
    var data: T? = null,
    val message: String? = null
)
