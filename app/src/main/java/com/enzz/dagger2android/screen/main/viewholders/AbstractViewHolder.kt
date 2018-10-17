package com.enzz.dagger2android.screen.main.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.enzz.dagger2android.screen.main.adapters.AbstractRecyclerViewAdapter

/**
 * Created by eniz.bilgin on 17.10.2018.
 */
abstract class AbstractViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView), AbstractRecyclerViewAdapter.Binder<T>