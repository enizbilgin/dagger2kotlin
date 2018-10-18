package com.enzz.dagger2android.di

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides


/**
 * Created by eniz.bilgin on 9.10.2018.
 */

@Module
abstract class ActivityModule<T : Activity> {

    @Provides
    @ActivityScope
    fun context(activity: T): Context {
        return activity
    }
}