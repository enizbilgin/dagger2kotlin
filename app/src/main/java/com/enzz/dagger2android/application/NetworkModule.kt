package com.enzz.dagger2android.application

import com.enzz.dagger2android.di.ApplicationScope
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by eniz.bilgin on 9.10.2018.
 */

@Module()
class NetworkModule {

    @ApplicationScope
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @ApplicationScope
    @Provides
    fun providePicasso(application: SampleApplication): Picasso {

        val picasso: Picasso = Picasso.Builder(application.applicationContext)
                .build()

        Picasso.setSingletonInstance(picasso)

        return picasso
    }
}