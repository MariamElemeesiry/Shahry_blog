package com.example.shahry_blog.data.data_source.remote

import com.example.shahry_blog.data.entities.AuthorEntity
import com.example.shahry_blog.data.entities.CommentsEntity
import com.example.shahry_blog.data.entities.PostsEntity
import io.reactivex.Maybe
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ShahryBlogClient {

    @GET("posts")
    suspend fun getPosts(
        @Query("_page") page: Int = 1,
        @Query("_limit") limit: Int = 20,
        @Query("_sort") _sort: String = "date",
        @Query("_order") _order: String = "desc"
    ): List<PostsEntity>

    @GET("authors")
    fun getAllAuthors(): Single<List<AuthorEntity>>

    @GET("posts")
    suspend fun getAllAuthorsPosts(
        @Query("_page") page: Int = 1,
        @Query("_limit") limit: Int = 20,
        @Query("authorId") authorId: Long,
        @Query("_sort") _sort: String = "date",
        @Query("_order") _order: String = "desc"
    ): List<PostsEntity>

    @GET("authors")
    fun getPostAuthor(
        @Query("id") id: Long,
    ): Maybe<AuthorEntity>

    @GET("posts/{post_id}/comments")
    fun getCommentsForPost(
        @Path(value = "post_id", encoded = true) post_id: Long,
        @Query("_sort") _sort: String = "date",
        @Query("_order") _order: String = "desc"
    ): Single<List<CommentsEntity>>

}