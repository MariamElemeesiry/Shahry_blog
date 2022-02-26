package com.example.shahry_blog.presentation.article_detatils

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shahry_blog.databinding.CommentItemBinding
import com.example.shahry_blog.presentation.models.Comments

class CommentsAdapter internal constructor(data: List<Comments>, ctx: Context) :
    RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {
    private val mData: List<Comments> = data
    val context = ctx


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.form(
            parent
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ViewHolder
    constructor(
        val
        binding: CommentItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Comments) {
            binding.comment = item
            binding
            binding.executePendingBindings()
        }

        companion object {
            fun form(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = CommentItemBinding.inflate(inflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }
    }

}