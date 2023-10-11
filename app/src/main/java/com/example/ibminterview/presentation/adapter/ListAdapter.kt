package com.example.ibminterview.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ibminterview.databinding.ListItemBinding

class listAdapter(
): ListAdapter<String, listAdapter.NumberViewHolder>(StringDiff) {

    private var onItemClickListener: ((String, Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (String, Int) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        return NumberViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NumberViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) = with(binding) {
            numberText.text = item
            binding.root.setOnClickListener {
                onItemClickListener?.invoke(item,adapterPosition)
            }
        }
    }
}

object StringDiff: DiffUtil.ItemCallback<String>(){
    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem.equals(newItem)
    }
}