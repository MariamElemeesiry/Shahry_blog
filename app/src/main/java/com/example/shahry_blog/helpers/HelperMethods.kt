package com.example.shahry_blog.helpers

import android.content.Context
import android.net.Uri
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader
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
