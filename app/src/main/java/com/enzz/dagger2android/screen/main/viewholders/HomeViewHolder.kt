package com.enzz.dagger2android.screen.main.viewholders

import android.view.View
import com.enzz.dagger2android.screen.main.models.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home.view.*

/**
 * Created by eniz.bilgin on 17.10.2018.
 */

class HomeViewHolder(itemView: View) : AbstractViewHolder<Photo>(itemView) {

    override fun bind(data: Photo) {
        itemView.textName.text = data.title
        Picasso.get().load(data.url).into(itemView.imageItem)
    }
}