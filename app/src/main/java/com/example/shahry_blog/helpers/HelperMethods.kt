package com.example.shahry_blog.helpers

import android.content.Context
import android.net.Uri
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader


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
