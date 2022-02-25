package com.example.shahry_blog.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shahry_blog.R
import com.example.shahry_blog.databinding.FragmentAuthorsListBinding
import com.example.shahry_blog.helpers.bind

class AuthorsListFragment : Fragment() {
    lateinit var binding: FragmentAuthorsListBinding

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

        }
    }
}