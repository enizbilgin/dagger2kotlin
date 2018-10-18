package com.enzz.dagger2android.application

import com.squareup.picasso.Downloader
import okhttp3.Request
import okhttp3.Response

/**
 * Created by eniz.bilgin on 18.10.2018.
 */
class MyHttpClient : Downloader {
    override fun shutdown() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun load(request: Request): Response {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}