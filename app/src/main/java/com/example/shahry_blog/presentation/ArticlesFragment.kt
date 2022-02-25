package com.example.shahry_blog.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shahry_blog.R
import com.example.shahry_blog.databinding.FragmentArticlesBinding
import com.example.shahry_blog.helpers.bind

class ArticlesFragment : Fragment() {
    lateinit var binding: FragmentArticlesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bind<FragmentArticlesBinding>(
            R.layout.fragment_articles,
            inflater,
            container
        ) { bind ->
            this.binding = bind

        }
    }

}