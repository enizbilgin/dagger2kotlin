package com.enzz.dagger2android.screen.main.activities

import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by eniz.bilgin on 17.10.2018.
 */

abstract class AbstractHomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var compositeDisposable: CompositeDisposable


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}