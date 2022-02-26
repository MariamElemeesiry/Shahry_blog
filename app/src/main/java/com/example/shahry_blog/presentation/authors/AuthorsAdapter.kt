package com.example.shahry_blog.presentation.authors

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shahry_blog.databinding.AuthorItemBinding
import com.example.shahry_blog.presentation.models.Author

class AuthorsAdapter internal constructor(data: List<Author>, ctx: Context) :
    RecyclerView.Adapter<AuthorsAdapter.ViewHolder>() {
    private val mData: List<Author> = data
    val context = ctx
    private var mListener: OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.form(
            parent
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mData[position], mListener)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ViewHolder
    constructor(
        val
        binding: AuthorItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Author, mListener: OnItemClickListener?) {
            binding.author = item
            binding.root.setOnClickListener {
                mListener?.onItemClicked(item)
            }
            binding.executePendingBindings()
        }

        companion object {
            fun form(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = AuthorItemBinding.inflate(inflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(item: Author)
    }

    fun setOnItemClickListener(mListener: OnItemClickListener) {
        this.mListener = mListener
    }

}