package com.example.shahry_blog.helpers

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader
import io.reactivex.Single
import java.net.HttpURLConnection
import java.net.URL
import java.time.OffsetDateTime


private const val SECOND_MILLIS = 1000
private const val MINUTE_MILLIS = 60 * SECOND_MILLIS
private const val HOUR_MILLIS = 60 * MINUTE_MILLIS
private const val DAY_MILLIS = 24 * HOUR_MILLIS
private const val WEEK_MILLIS = 4 * DAY_MILLIS

fun getTimeAgo(time: OffsetDateTime): String? {
    var time = time.toInstant().toEpochMilli()
    if (time < 1000000000000L) {
        // if timestamp given in seconds, convert to millis
        time *= 1000
    }
    val now: Long = OffsetDateTime.now().toInstant().toEpochMilli()
    if (time > now || time <= 0) {
        return null
    }

    // TODO: localize
    val diff = now - time
    return if (diff < MINUTE_MILLIS) {
        "just now"
    } else if (diff < 2 * MINUTE_MILLIS) {
        "a minute ago"
    } else if (diff < 50 * MINUTE_MILLIS) {
        (diff / MINUTE_MILLIS).toString() + " minutes ago"
    } else if (diff < 90 * MINUTE_MILLIS) {
        "an hour ago"
    } else if (diff < 24 * HOUR_MILLIS) {
        (diff / HOUR_MILLIS).toString() + " hours ago"
    } else if (diff < 48 * HOUR_MILLIS) {
        "yesterday"
    } else if (diff < WEEK_MILLIS) {
        (diff / DAY_MILLIS).toString() + " days ago"
    } else {
        (diff / WEEK_MILLIS).toString() + " weeks ago"
    }
}

fun isNetworkAvailable(context: Context?): Boolean {
    if (context == null) return false
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    return true
                }
            }
        }
    } else {
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
            return true
        }
    }
    return false
}

//TODO::change google url with shahry server check to check if any firewall
fun checkServerAndInternetConnection(
    ipAddress: String = "http://www.google.com",
    context: Context?
): Single<Boolean> {
    lateinit var connection: HttpURLConnection
    return if (isNetworkAvailable(context)) {
        try {
            Single.just(false).flatMap {
                val url = URL(ipAddress)
                connection = url.openConnection() as (HttpURLConnection)
                Single.just(connection.responseCode == 200)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Single.just(false)
        }
    } else Single.just(false)
}

fun Uri.clearFrescoCash(): Uri {
    val imagePipeline = Fresco.getImagePipeline()
    imagePipeline.evictFromCache(this)
    imagePipeline.clearCaches()
    return this
}

fun Context.initFresco() {
    val builder = ImagePipelineConfig.newBuilder(this.applicationContext)
    var imagePipelineConfig = builder.build()
    Fresco.initialize(this.applicationContext, imagePipelineConfig)
    try {
        ImagePipelineNativeLoader.load()
    } catch (error: UnsatisfiedLinkError) {
        Fresco.shutDown()
        builder.experiment().setNativeCodeDisabled(true)
        imagePipelineConfig = builder.build()
        Fresco.initialize(this.applicationContext, imagePipelineConfig)
        error.printStackTrace()
    }
}
