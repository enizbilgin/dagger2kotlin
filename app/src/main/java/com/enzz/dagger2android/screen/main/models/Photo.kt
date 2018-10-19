package com.enzz.dagger2android.screen.main.models

import com.squareup.moshi.Json

/**
 * Created by eniz.bilgin on 17.10.2018.
 */

data class Photo(
        @field:Json(name = "albumId") val albumId: Int?,
        @field:Json(name = "id") val id: Int?,
        @field:Json(name = "title") val title: String?,
        @field:Json(name = "url") val url: String?,
        @field:Json(name = "thumbnailUrl") val thumbnailUrl: String?
)
