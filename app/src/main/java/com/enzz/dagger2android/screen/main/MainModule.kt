package com.enzz.dagger2android.screen.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.enzz.dagger2android.di.ActivityModule
import com.enzz.dagger2android.di.ActivityScope
import com.enzz.dagger2android.di.FragmentScope
import com.enzz.dagger2android.screen.main.activities.HomeActivity
import com.enzz.dagger2android.screen.main.adapters.HomeListAdapter
import com.enzz.dagger2android.screen.main.adapters.HomePagerAdapter
import com.enzz.dagger2android.screen.main.fragments.FirstHomeFragment
import com.enzz.dagger2android.screen.main.fragments.SecondHomeFragment
import com.enzz.dagger2android.screen.main.fragments.ThirdHomeFragment
import com.enzz.dagger2android.screen.main.services.MainService
import com.enzz.dagger2android.screen.main.viewmodels.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit


/**
 * Created by eniz.bilgin on 9.10.2018.
 */

class MainModule {

    @Module
    class MainActivityModule : ActivityModule<HomeActivity>() {

        // Main Activity module
        @ActivityScope
        @Provides
        fun provideService(retrofit: Retrofit): MainService {
            return retrofit.create<MainService>(MainService::class.java)
        }

        @ActivityScope
        @Provides
        fun provideViewModel(activity: HomeActivity, service: MainService): MainViewModel {
            val viewModel = ViewModelProviders.of(activity).get(MainViewModel::class.java)
            viewModel.setService(service)
            return viewModel
        }

        @ActivityScope
        @Provides
        fun providePagerAdapter(activity: HomeActivity): HomePagerAdapter {
            val homePagerAdapter = HomePagerAdapter(activity.supportFragmentManager)
            homePagerAdapter.addFragment(Fragment.instantiate(activity, FirstHomeFragment::class.java.name), "")
            homePagerAdapter.addFragment(Fragment.instantiate(activity, SecondHomeFragment::class.java.name), "")
            homePagerAdapter.addFragment(Fragment.instantiate(activity, ThirdHomeFragment::class.java.name), "")
            return homePagerAdapter
        }

        @ActivityScope
        @Provides
        fun provideListAdapter(): HomeListAdapter {
            return HomeListAdapter()
        }

        @ActivityScope
        @Provides
        fun provideDisposable(): CompositeDisposable {
            return CompositeDisposable()
        }

        @Module
        abstract class MainFragmentsModule {

            @FragmentScope
            @ContributesAndroidInjector(modules = arrayOf())
            internal abstract fun firstFragment(): FirstHomeFragment

            @FragmentScope
            @ContributesAndroidInjector(modules = arrayOf())
            internal abstract fun secondFragment(): SecondHomeFragment

            @FragmentScope
            @ContributesAndroidInjector(modules = arrayOf())
            internal abstract fun thirdFragment(): ThirdHomeFragment
        }
    }

    @Module
    abstract inner class MainModuleScreenModule {

        @ActivityScope
        @ContributesAndroidInjector(modules = arrayOf(MainModule.MainActivityModule::class, MainModule.MainActivityModule.MainFragmentsModule::class))
        internal abstract fun mainActivity(): HomeActivity
    }
}