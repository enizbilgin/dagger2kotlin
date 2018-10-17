package com.enzz.dagger2android.screen.main.models

import com.google.gson.annotations.SerializedName

/**
 * Created by eniz.bilgin on 17.10.2018.
 */

data class Photo(
        @SerializedName("albumId") val albumId: Int?,
        @SerializedName("id") val id: Int?,
        @SerializedName("title") val title: String?,
        @SerializedName("url") val url: String?,
        @SerializedName("thumbnailUrl") val thumbnailUrl: String?
)
