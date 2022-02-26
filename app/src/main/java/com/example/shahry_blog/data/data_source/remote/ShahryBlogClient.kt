package com.example.shahry_blog.data.data_source.remote

import com.example.shahry_blog.data.entities.AuthorEntity
import com.example.shahry_blog.data.entities.CommentsEntity
import com.example.shahry_blog.data.entities.PostsEntity
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ShahryBlogClient {

    @GET("posts")
    fun getPosts(
        @Query("_page") page: Int = 1,
        @Query("_limit") limit: Int = 20,
        @Query("_sort") _sort: String = "date",
        @Query("_order") _order: String = "desc"
    ): Single<Response<List<PostsEntity>>>

    @GET("authors")
    fun getAllAuthors(): Single<Response<List<AuthorEntity>>>

    @GET("posts")
    fun getAllAuthorsPosts(
        @Query("authorId") authorId: Long,
        @Query("_sort") _sort: String = "date",
        @Query("_order") _order: String = "desc"
    ): Single<Response<List<AuthorEntity>>>

    @GET("posts/{post_id}/comments")
    fun getCommentsForPost(
        @Path(value = "post_id", encoded = true) post_id: Long,
        @Query("_sort") _sort: String = "date",
        @Query("_order") _order: String = "desc"
    ): Single<Response<List<CommentsEntity>>>

}