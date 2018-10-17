package com.enzz.dagger2android.screen.main.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by eniz.bilgin on 17.10.2018.
 */

abstract class AbstractPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private val fragments = ArrayList<Fragment>()

    private val titles = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        if (titles.isEmpty()) {
            return ""
        }
        return titles[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }

    fun setItems(fragmentList: List<Fragment>) {
        fragments.clear()
        fragments.addAll(fragmentList)
    }
}