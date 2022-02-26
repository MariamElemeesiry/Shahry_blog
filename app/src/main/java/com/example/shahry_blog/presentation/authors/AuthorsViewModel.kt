package com.example.shahry_blog.presentation.authors

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
        getAllAuthors()
    }

    private fun getAllAuthors() {
        _authorsList.setLoading()
        compositeDisposable.add(authorsUseCase.getAllAuthors().subscribe({
            _authorsList.setSuccess(it)
        }, {
            _authorsList.setError()
            it.printStackTrace()
        }))
    }
}