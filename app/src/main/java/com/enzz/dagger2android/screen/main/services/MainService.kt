package com.enzz.dagger2android.screen.main.services

import com.enzz.dagger2android.screen.main.models.Photo
import io.reactivex.Observable
import retrofit2.http.GET


/**
 * Created by eniz.bilgin on 9.10.2018.
 */

interface MainService {

    @GET("photos")
    fun getPhotos(): Observable<List<Photo>>
}