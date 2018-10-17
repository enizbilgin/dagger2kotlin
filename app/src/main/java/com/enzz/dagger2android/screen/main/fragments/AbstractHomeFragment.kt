package com.enzz.dagger2android.screen.main.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.enzz.dagger2android.screen.main.adapters.HomeListAdapter
import dagger.android.support.HasSupportFragmentInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject
import dagger.android.support.AndroidSupportInjection
import dagger.android.AndroidInjector
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by eniz.bilgin on 17.10.2018.
 */

abstract class AbstractHomeFragment : Fragment(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    @Inject
    lateinit var adapter: HomeListAdapter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    abstract fun getLayoutId(): Int

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

}