package com.enzz.dagger2android.application

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by eniz.bilgin on 9.10.2018.
 */

class SampleApplication : DaggerApplication() {

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerSampleApplicationComponent.builder().application(this).create(this)
    }
}