package com.example.shahry_blog.data.data_source

import androidx.paging.PagingSource
import com.example.shahry_blog.data.entities.PostsEntity

interface PostsDataSource {
    fun getAllPosts(page: Int, limit: Int): PagingSource<Int, PostsEntity>
    fun getAuthorArticles(page: Int, limit: Int, authorId: Long): PagingSource<Int, PostsEntity>
}