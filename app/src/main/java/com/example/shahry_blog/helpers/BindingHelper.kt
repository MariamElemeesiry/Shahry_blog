package com.example.shahry_blog.helpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


inline fun <T : ViewDataBinding> FragmentActivity.bind(
    @LayoutRes layoutToBind: Int,
    invoke: (T) -> Unit
) {
    val dataBinding = DataBindingUtil.setContentView(this, layoutToBind) as T
    dataBinding.lifecycleOwner = this
    setContentView(dataBinding.root)
    invoke.invoke(dataBinding)
}

inline fun <T : ViewDataBinding> Fragment.bind(
    @LayoutRes layoutToBind: Int, inflater: LayoutInflater,
    container: ViewGroup?,
    attachToParent: Boolean = false,
    invoke: (T) -> Unit
): View {
    val dataBinding =
        DataBindingUtil.inflate(inflater, layoutToBind, container, attachToParent) as T
    invoke.invoke(dataBinding)
    dataBinding.lifecycleOwner = this
    return dataBinding.root
}

inline fun <reified T : ViewDataBinding> ViewGroup.bind(
    @LayoutRes layoutToBind: Int,
    attachToParent: Boolean = false
): T {
    val inflater = LayoutInflater.from(this.context)
    return DataBindingUtil.inflate(inflater, layoutToBind, this, attachToParent)
}