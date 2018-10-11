package com.enzz.dagger2android.screen.main

import androidx.lifecycle.ViewModelProviders
import com.enzz.dagger2android.di.ActivityModule
import com.enzz.dagger2android.di.ActivityScope
import com.enzz.dagger2android.screen.main.activities.MainActivity
import com.enzz.dagger2android.screen.main.services.MainService
import com.enzz.dagger2android.screen.main.viewmodels.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit


/**
 * Created by eniz.bilgin on 9.10.2018.
 */

class MainModule {

    @Module
    class MainActivityModule : ActivityModule<MainActivity>() {

        // Main Activity module
        @ActivityScope
        @Provides
        fun provideService(retrofit: Retrofit): MainService {
            return retrofit.create<MainService>(MainService::class.java)
        }

        @ActivityScope
        @Provides
        fun provideViewModel(activity: MainActivity, service: MainService): MainViewModel {
            val viewModel = ViewModelProviders.of(activity).get(MainViewModel::class.java)
            viewModel.setService(service)
            return viewModel
        }

    }

    @Module
    abstract inner class MainModuleScreenModule {

        @ActivityScope
        @ContributesAndroidInjector(modules = arrayOf(MainModule.MainActivityModule::class))
        internal abstract fun mainActivity(): MainActivity
    }
}