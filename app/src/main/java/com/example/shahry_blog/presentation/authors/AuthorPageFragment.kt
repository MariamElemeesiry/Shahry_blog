package com.example.shahry_blog.presentation.authors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shahry_blog.R
import com.example.shahry_blog.databinding.FragmentAuthorPageBinding
import com.example.shahry_blog.helpers.bind
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorPageFragment : Fragment() {
    lateinit var binding: FragmentAuthorPageBinding

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

        }
    }
}