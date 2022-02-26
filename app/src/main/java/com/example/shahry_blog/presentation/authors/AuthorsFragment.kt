package com.example.shahry_blog.presentation.authors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shahry_blog.R
import com.example.shahry_blog.databinding.FragmentAuthorsBinding
import com.example.shahry_blog.helpers.bind
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorsFragment : Fragment() {

    lateinit var binding: FragmentAuthorsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return bind<FragmentAuthorsBinding>(
            R.layout.fragment_authors,
            inflater,
            container
        ) { bind ->
            this.binding = bind

        }
    }
}