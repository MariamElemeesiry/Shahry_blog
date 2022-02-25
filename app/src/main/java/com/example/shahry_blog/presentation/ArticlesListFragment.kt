package com.example.shahry_blog.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shahry_blog.R
import com.example.shahry_blog.databinding.FragmentArticlesListBinding
import com.example.shahry_blog.helpers.bind

class ArticlesListFragment : Fragment() {
    lateinit var binding: FragmentArticlesListBinding


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

        }
    }

}