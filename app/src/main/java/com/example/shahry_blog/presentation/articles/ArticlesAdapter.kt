package com.example.shahry_blog.presentation.articles

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shahry_blog.databinding.ArticleItemBinding
import com.example.shahry_blog.presentation.models.Articles

class ArticlesAdapter :
    PagingDataAdapter<Articles, ArticlesAdapter.ViewHolder>(ArticlesDiffCallback()) {

    private var mListener: OnItemClickListener? = null

    class ArticlesDiffCallback : DiffUtil.ItemCallback<Articles>() {

        override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.form(
            parent
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, mListener) }
    }

    class ViewHolder
    constructor(
        val
        binding: ArticleItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Articles, mListener: OnItemClickListener?) {


            binding.article = item
            binding.root.setOnClickListener {
                mListener?.onItemClicked(item)
            }

            binding.executePendingBindings()
        }

        companion object {
            fun form(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ArticleItemBinding.inflate(inflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(item: Articles)
    }

    fun setOnItemClickListener(mListener: OnItemClickListener) {
        this.mListener = mListener
    }
}