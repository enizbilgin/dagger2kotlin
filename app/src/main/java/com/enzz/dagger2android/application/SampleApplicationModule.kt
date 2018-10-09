package com.enzz.dagger2android.application

import com.enzz.dagger2android.screen.ScreenModule
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule


/**
 * Created by eniz.bilgin on 9.10.2018.
 */


@Module(includes = arrayOf(AndroidSupportInjectionModule::class, NetworkModule::class, ScreenModule::class))
abstract class SampleApplicationModule {

}