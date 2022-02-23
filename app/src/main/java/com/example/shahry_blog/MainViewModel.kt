package com.example.shahry_blog

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.shahry_blog.data.data_source.remote.ShahryBlogClient
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val networkClient: ShahryBlogClient) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

//    init {
//        getPosts()
//    }


    fun getPosts() {
        compositeDisposable.add(
            networkClient.getPosts().subscribeOn(Schedulers.io()).subscribe({
                Log.e("RETRO", "body>>${it.body()}")
                Log.d("RETRO", "headers>>${it.headers()["Link"]}")
            }, {
                it.printStackTrace()
            })
        )
    }
}