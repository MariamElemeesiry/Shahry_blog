package com.example.shahry_blog.helpers

data class PagingResponse<T> constructor(
    var data: T? = null,
    var next: Long? = null,
    var prev: Long? = null
)
