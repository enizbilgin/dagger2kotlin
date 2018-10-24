package com.enzz.dagger2android.screen.main.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.enzz.dagger2android.R
import com.enzz.dagger2android.screen.main.adapters.AbstractRecyclerViewAdapter
import com.enzz.dagger2android.screen.main.models.Photo
import com.enzz.dagger2android.screen.main.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


/**
 * Created by eniz.bilgin on 17.10.2018.
 */

class FirstHomeFragment : AbstractHomeFragment() {


    @Inject
    lateinit var viewModel: MainViewModel

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val layoutManager = LinearLayoutManager(requireContext())
        homeList.layoutManager = layoutManager

        homeList.adapter = adapter

        adapter.setOnOnItemClickListener(object : AbstractRecyclerViewAdapter.OnItemClickListener<Photo> {
            override fun onItemClick(data: Photo) {
                Toast.makeText(requireContext(), data.title, Toast.LENGTH_SHORT).show()
            }
        });

        compositeDisposable.add(
                viewModel.photosSubject
                        .subscribe({ items ->
                            adapter.setItems(items)
                        }, {
                        }))
    }
}
