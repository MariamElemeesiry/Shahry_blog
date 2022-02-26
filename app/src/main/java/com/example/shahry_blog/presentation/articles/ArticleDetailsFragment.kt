package com.example.shahry_blog.presentation.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shahry_blog.R
import com.example.shahry_blog.databinding.FragmentArticleDetailsBinding
import com.example.shahry_blog.helpers.bind
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleDetailsFragment : Fragment() {
    lateinit var binding: FragmentArticleDetailsBinding


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

        }
    }

}