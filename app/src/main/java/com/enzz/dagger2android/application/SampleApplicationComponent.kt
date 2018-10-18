package com.enzz.dagger2android.application

import com.enzz.dagger2android.di.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

/**
 * Created by eniz.bilgin on 9.10.2018.
 */

@ApplicationScope
@Component(modules = arrayOf(SampleApplicationModule::class))
interface SampleApplicationComponent : AndroidInjector<SampleApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<SampleApplication>() {

        abstract override fun build(): SampleApplicationComponent
    }
}