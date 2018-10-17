package com.enzz.dagger2android.screen.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enzz.dagger2android.screen.main.viewholders.AbstractViewHolder

/**
 * Created by eniz.bilgin on 17.10.2018.
 */

abstract class AbstractRecyclerViewAdapter<T, H : AbstractViewHolder<T>>() : RecyclerView.Adapter<H>() {

    protected val itemList: ArrayList<T> = ArrayList()

    private var itemClickListener: OnItemClickListener<T>? = null

    constructor(listItems: List<T>) : this() {
        this.itemList.addAll(listItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): H {

        val holder: H = getViewHolder(LayoutInflater.from(parent.context)
                .inflate(viewType, parent, false), viewType)

        return holder
    }

    override fun onBindViewHolder(holder: H, position: Int) {
        // get data
        val data: T = itemList[position]
        // bind data holder
        holder.bind(data)
        // listen to click handler
        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(data)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutId(position, itemList[position])
    }

    protected abstract fun getLayoutId(position: Int, obj: T): Int

    protected abstract fun getViewHolder(view: View, viewType: Int): H

    fun setItems(listItems: List<T>) {
        this.itemList.clear()
        this.itemList.addAll(listItems)
        notifyDataSetChanged()
    }

    internal interface Binder<T> {
        fun bind(data: T)
    }

    interface OnItemClickListener<T> {
        fun onItemClick(data: T)
    }
}