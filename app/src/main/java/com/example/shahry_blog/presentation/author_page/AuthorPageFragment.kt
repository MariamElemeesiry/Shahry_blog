package com.example.shahry_blog.presentation.author_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.shahry_blog.R
import com.example.shahry_blog.databinding.FragmentAuthorPageBinding
import com.example.shahry_blog.helpers.bind
import com.example.shahry_blog.presentation.articles.ArticlesAdapter
import com.example.shahry_blog.presentation.models.Articles
import com.example.shahry_blog.presentation.models.Author
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AuthorPageFragment : Fragment(), ArticlesAdapter.OnItemClickListener {
    lateinit var binding: FragmentAuthorPageBinding
    private lateinit var author: Author
    private val viewModel: AuthorPageViewModel by viewModels()
    private var articlesAdapter = ArticlesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bind<FragmentAuthorPageBinding>(
            R.layout.fragment_author_page,
            inflater,
            container
        ) { bind ->
            this.binding = bind
            author = arguments?.getParcelable("author")!!
            articlesAdapter.setOnItemClickListener(this)
            bind.simpleDraweeView.setImageURI(author.avatarUrl)
            bind.articlesRv.adapter = articlesAdapter
            bind.nameTv.text = author.name
            bind.userEmailValueTv.text = author.email
            bind.userNameValueTv.text = author.userName
            lifecycleScope.launch {
                viewModel.getAuthorArticles(author.id).collectLatest { paging ->
                    articlesAdapter.submitData(viewLifecycleOwner.lifecycle, paging).let {
                        bind.progress.isVisible = false
                    }
                }
            }


        }
    }

    override fun onItemClicked(item: Articles) {
        val bundle = Bundle()
        bundle.putParcelable("article", item)
        findNavController().navigate(R.id.ArticleDetailsFragment, bundle)
    }
}