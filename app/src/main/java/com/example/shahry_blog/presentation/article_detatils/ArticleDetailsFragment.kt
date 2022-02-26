package com.example.shahry_blog.presentation.article_detatils

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.shahry_blog.R
import com.example.shahry_blog.databinding.FragmentArticleDetailsBinding
import com.example.shahry_blog.helpers.ResourceState
import com.example.shahry_blog.helpers.bind
import com.example.shahry_blog.presentation.models.Articles
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArticleDetailsFragment : Fragment() {
    lateinit var binding: FragmentArticleDetailsBinding
    private val viewModel: ArticleDetailsViewModel by viewModels()
    private lateinit var article: Articles
    private lateinit var commentsAdapter: CommentsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bind<FragmentArticleDetailsBinding>(
            R.layout.fragment_article_details,
            inflater,
            container
        ) { bind ->
            this.binding = bind
            article = arguments?.getParcelable("article")!!
            Log.e("ARTICLE", "$article")
            viewModel.getArticleDetails(article.id)
            bind.postIv.setImageURI(article.imageUrl)
            bind.articleTv.text = article.body
            bind.titleTv.text = article.title
            viewModel.commentsList.observe(viewLifecycleOwner) {
                when (it.state) {
                    ResourceState.SUCCESS -> {
                        commentsAdapter = CommentsAdapter(it.data!!, requireContext())
                        bind.commentsRv.adapter = commentsAdapter

                    }
                }

            }


        }
    }

}