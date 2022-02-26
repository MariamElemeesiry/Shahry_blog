package com.example.shahry_blog

import android.app.Application
import com.example.shahry_blog.helpers.initFresco
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp:Application() {

    override fun onCreate() {
        super.onCreate()
        initFresco()
    }
}