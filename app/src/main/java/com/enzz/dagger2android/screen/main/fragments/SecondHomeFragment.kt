package com.enzz.dagger2android.screen.main.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.enzz.dagger2android.R
import com.enzz.dagger2android.screen.main.adapters.HomeListAdapter
import com.enzz.dagger2android.screen.main.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


/**
 * Created by eniz.bilgin on 17.10.2018.
 */

class SecondHomeFragment : AbstractHomeFragment() {


    @Inject
    lateinit var viewModel: MainViewModel

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HomeListAdapter()

        val layoutManager = GridLayoutManager(requireContext(),2)
        homeList.layoutManager = layoutManager

        homeList.adapter = adapter

        compositeDisposable.add(
                viewModel.photosSubject
                        .subscribe({ items ->
                            adapter.setItems(items)
                        }, {
                        }))
    }
}
