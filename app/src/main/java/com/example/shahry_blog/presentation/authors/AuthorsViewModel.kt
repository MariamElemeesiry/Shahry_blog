package com.example.shahry_blog.presentation.authors

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shahry_blog.domain.usecases.AuthorsUseCase
import com.example.shahry_blog.helpers.Resource
import com.example.shahry_blog.helpers.setError
import com.example.shahry_blog.helpers.setLoading
import com.example.shahry_blog.helpers.setSuccess
import com.example.shahry_blog.presentation.models.Author
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class AuthorsViewModel @Inject constructor(val authorsUseCase: AuthorsUseCase) :
    ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val _authorsList: MutableLiveData<Resource<List<Author>>> = MutableLiveData()
    val authorsList: LiveData<Resource<List<Author>>> = _authorsList

    init {
        Log.e("RETRO", "init called")
        getAllAuthors()
    }

    private fun getAllAuthors() {
        _authorsList.setLoading()
        compositeDisposable.add(authorsUseCase.getAllAuthors().subscribe({
            Log.e("RETRO", "setSuccess>>$it")
            _authorsList.setSuccess(it)
        }, {
            _authorsList.setError()
            Log.e("RETRO", "setError>>${it.stackTraceToString()}")
            it.printStackTrace()
        }))
    }
}