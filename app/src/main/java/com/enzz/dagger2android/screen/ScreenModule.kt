package com.enzz.dagger2android.screen

import com.enzz.dagger2android.screen.main.MainModule
import dagger.Module

/**
 * Created by eniz.bilgin on 9.10.2018.
 */

@Module(includes = arrayOf(
        MainModule.MainModuleScreenModule::class
        ))
abstract class ScreenModule