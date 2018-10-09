package com.enzz.dagger2android.screen.main.services

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by eniz.bilgin on 9.10.2018.
 */

interface MainService {

    @GET("trends/user.json")
    fun getUsers(@Query("id") placeId: String): Observable<List<String>>

}