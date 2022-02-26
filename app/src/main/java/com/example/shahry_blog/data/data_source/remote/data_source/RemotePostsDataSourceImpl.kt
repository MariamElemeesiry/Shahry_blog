package com.example.shahry_blog.data.data_source.remote.data_source

import com.example.shahry_blog.data.data_source.PostsDataSource
import com.example.shahry_blog.data.data_source.local.database.dao.PostsDao
import com.example.shahry_blog.data.data_source.remote.ShahryBlogClient
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemotePostsDataSourceImpl @Inject constructor(
    private val networkClient: ShahryBlogClient,
    private val postsDao: PostsDao
) :
    PostsDataSource {
    override fun getAllPosts(page: Int, limit: Int) =
        PostsPagingSource(apiCall = { page, limit ->
            networkClient.getPosts(page, limit).map {
                postsDao.insertOrUpdate(it).subscribeOn(Schedulers.io()).subscribe()
                it
            }
        })

    override fun getAuthorArticles(
        page: Int,
        limit: Int,
        authorId: Long
    ) =
        PostsPagingSource(apiCall = { page, limit ->
            networkClient.getAllAuthorsPosts(page, limit, authorId).map {
                postsDao.insertOrUpdate(it).subscribeOn(Schedulers.io()).subscribe()
                it
            }
        })

}