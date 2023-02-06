package com.srj.marvelworld.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.srj.marvelworld.BR

abstract class BaseAdapter<T>(
    private var _items: List<T>,
    private val _listener: BaseInteractionListener
) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    @get:LayoutRes
    abstract val layoutID: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), layoutID, parent, false
            )
        )

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> bind(holder, position)
        }
    }

    private fun bind(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            setVariable(BR.item, _items[position])
            setVariable(BR.listener, _listener)
        }
    }

    override fun getItemCount() = _items.size

    fun setItems(newItems: List<T>) {
        val diffResult = DiffUtil.calculateDiff(SimpleDiffUtil(_items, newItems){ oldItem, newItem ->
            areItemsTheSame(oldItem, newItem)
        })
        _items = newItems
        diffResult.dispatchUpdatesTo(this)
        notifyDataSetChanged()
    }

    fun getItem() = _items
    open fun areItemsTheSame(oldItem: T, newItem: T): Boolean = oldItem?.equals(newItem) == true


    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)

    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}