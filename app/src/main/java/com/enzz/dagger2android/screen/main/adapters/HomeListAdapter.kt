package com.enzz.dagger2android.screen.main.adapters

import android.view.View
import com.enzz.dagger2android.R
import com.enzz.dagger2android.screen.main.models.Photo
import com.enzz.dagger2android.screen.main.viewholders.HomeViewHolder

/**
 * Created by eniz.bilgin on 17.10.2018.
 */

class HomeListAdapter : AbstractRecyclerViewAdapter<Photo, HomeViewHolder>() {

    override fun getLayoutId(position: Int, obj: Photo): Int {
        return R.layout.item_home
    }

    override fun getViewHolder(view: View, viewType: Int): HomeViewHolder {
        return HomeViewHolder(view)
    }
}