package com.example.shahry_blog.presentation.authors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.shahry_blog.R
import com.example.shahry_blog.databinding.FragmentAuthorsListBinding
import com.example.shahry_blog.helpers.ResourceState
import com.example.shahry_blog.helpers.bind
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorsListFragment : Fragment() {
    lateinit var binding: FragmentAuthorsListBinding
    private val viewModel: AuthorsViewModel by viewModels()
    private lateinit var authorsAdapter: AuthorsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bind<FragmentAuthorsListBinding>(
            R.layout.fragment_authors_list,
            inflater,
            container
        ) { bind ->
            this.binding = bind
            bind.vm = viewModel
            viewModel.authorsList.observe(viewLifecycleOwner) {
                when (it.state) {
                    ResourceState.SUCCESS -> {
                        authorsAdapter = AuthorsAdapter(it.data!!, requireContext())
                        bind.articlesRv.adapter = authorsAdapter
                    }
                }
            }

        }
    }
}