package com.enzz.dagger2android.screen.main.activities

import android.os.Bundle
import com.enzz.dagger2android.R
import com.enzz.dagger2android.screen.main.adapters.HomePagerAdapter
import com.enzz.dagger2android.screen.main.viewmodels.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class HomeActivity : AbstractHomeActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var pagerAdapter: HomePagerAdapter

    @Inject
    lateinit var picasso: Picasso


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepareData()
        setupUi()
    }

    private fun prepareData() {
        compositeDisposable.add(
                viewModel.getPhotos().subscribe()
        )
    }

    private fun setupUi() {
        // set viewpager adapter
        viewPager.adapter = pagerAdapter
        viewPager.offscreenPageLimit = 3
        // listen to navigation selected listener
        navigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_one -> viewPager.currentItem = 0
                R.id.action_two -> viewPager.currentItem = 1
                R.id.action_three -> viewPager.currentItem = 2
                else -> { // Note the block
                    println("x is neither 1 nor 2")
                    return@OnNavigationItemSelectedListener false
                }
            }
            true
        })
    }

}
