package com.example.shahry_blog.helpers

import android.net.Uri
import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView


@BindingAdapter("setImageUri")
fun SimpleDraweeView.setImageUri(src: Uri?) {
    src?.let { this.setImageURI(src.clearFrescoCash()) }
}


@BindingAdapter("setImageUri")
fun SimpleDraweeView.setImageUri(src: String?) {
    val uri = Uri.parse(src)
    src?.let { this.setImageURI(uri.clearFrescoCash()) }
}