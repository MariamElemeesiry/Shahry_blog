package com.example.shahry_blog.presentation.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.shahry_blog.R
import com.example.shahry_blog.databinding.FragmentArticlesListBinding
import com.example.shahry_blog.helpers.bind
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ArticlesListFragment : Fragment() {
    lateinit var binding: FragmentArticlesListBinding
    private val viewModel: ArticlesViewModel by viewModels()
    private var articlesAdapter = ArticlesAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bind<FragmentArticlesListBinding>(
            R.layout.fragment_articles_list,
            inflater,
            container
        ) { bind ->
            this.binding = bind
            bind.articlesRv.adapter = articlesAdapter
            bind.progress.isVisible = true
            lifecycleScope.launch {
                viewModel.getAllArticles().collectLatest { paging ->
                    articlesAdapter.submitData(viewLifecycleOwner.lifecycle, paging).let {
                        bind.progress.isVisible = false
                    }
                }
            }

        }
    }

}