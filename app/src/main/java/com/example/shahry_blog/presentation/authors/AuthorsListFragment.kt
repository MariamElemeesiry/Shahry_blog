package com.example.shahry_blog.presentation.authors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shahry_blog.R
import com.example.shahry_blog.databinding.FragmentAuthorsListBinding
import com.example.shahry_blog.helpers.ResourceState
import com.example.shahry_blog.helpers.bind
import com.example.shahry_blog.presentation.models.Author
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorsListFragment : Fragment(), AuthorsAdapter.OnItemClickListener {
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
                        authorsAdapter.setOnItemClickListener(this)
                        bind.articlesRv.adapter = authorsAdapter
                    }
                }
            }

        }
    }

    override fun onItemClicked(item: Author) {
        val bundle = Bundle()
        bundle.putParcelable("author", item)
        findNavController().navigate(R.id.AuthorPageFragment, bundle)
    }
}