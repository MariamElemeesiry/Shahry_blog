package com.example.shahry_blog.data.data_source.remote.data_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.shahry_blog.data.entities.PostsEntity
import retrofit2.HttpException
import java.io.IOException

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class PostsPagingSource(val apiCall: suspend (page: Int, limit: Int) -> List<PostsEntity>) :
    PagingSource<Int, PostsEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostsEntity> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX
        val response = apiCall(position, params.loadSize)

        return try {
            LoadResult.Page(
                data = response,
                prevKey = if (position == UNSPLASH_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (response.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PostsEntity>): Int? {
        TODO("Not yet implemented")
    }
}