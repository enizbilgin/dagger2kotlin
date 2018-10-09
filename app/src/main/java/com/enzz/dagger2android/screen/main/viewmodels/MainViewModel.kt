package com.enzz.dagger2android.screen.main.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.support.annotation.NonNull
import com.enzz.dagger2android.screen.main.services.MainService


/**
 * Created by eniz.bilgin on 9.10.2018.
 */

class MainViewModel(@NonNull application: Application) : AndroidViewModel(application) {

    private var service: MainService? = null

    fun setService(service: MainService) {
        this.service = service
    }
}