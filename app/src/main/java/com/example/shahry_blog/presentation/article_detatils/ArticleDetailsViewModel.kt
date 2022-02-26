package com.example.shahry_blog.presentation.article_detatils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shahry_blog.domain.usecases.AuthorsUseCase
import com.example.shahry_blog.domain.usecases.CommentsUseCase
import com.example.shahry_blog.helpers.Resource
import com.example.shahry_blog.helpers.setError
import com.example.shahry_blog.helpers.setLoading
import com.example.shahry_blog.helpers.setSuccess
import com.example.shahry_blog.presentation.models.Articles
import com.example.shahry_blog.presentation.models.Author
import com.example.shahry_blog.presentation.models.Comments
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class ArticleDetailsViewModel @Inject constructor(
    private val authorsUseCase: AuthorsUseCase,
    private val commentsUseCase: CommentsUseCase
) :
    ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val _commentsList: MutableLiveData<Resource<List<Comments>>> = MutableLiveData()
    val commentsList: LiveData<Resource<List<Comments>>> = _commentsList
    private val _author: MutableLiveData<Resource<Author>> = MutableLiveData()
    val author: LiveData<Resource<Author>> = _author
    val selectedArticle: MutableLiveData<Articles> = MutableLiveData()


    private fun getArticleComments(articleId: Long) {
        _commentsList.setLoading()
        compositeDisposable.add(commentsUseCase.getCommentsForArticle(articleId).subscribe({
            _commentsList.setSuccess(it)
        }, {
            _commentsList.setError()
            it.printStackTrace()
        }))
    }

    private fun getArticleAuthor(articleId: Long) {
        _commentsList.setLoading()
        compositeDisposable.add(commentsUseCase.getCommentsForArticle(articleId).subscribe({
            _commentsList.setSuccess(it)
        }, {
            _commentsList.setError()
            it.printStackTrace()
        }))
    }

    fun getArticleDetails(articleId: Long) {
        getArticleComments(articleId)
        getArticleAuthor(articleId)
    }

}