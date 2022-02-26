package com.example.shahry_blog.presentation.articles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.shahry_blog.domain.usecases.ArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(private val articlesUseCase: ArticlesUseCase) :
    ViewModel() {
    var loading = MutableLiveData(true)

    fun getAllArticles() = articlesUseCase.getAllArticles().onStart {
        loading.postValue(true)
        loading.value = true
    }.cachedIn(viewModelScope)

}