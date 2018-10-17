package com.enzz.dagger2android.screen.main.viewmodels

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import com.enzz.dagger2android.screen.main.models.Photo
import com.enzz.dagger2android.screen.main.services.MainService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject


/**
 * Created by eniz.bilgin on 9.10.2018.
 */

class MainViewModel(@NonNull application: Application) : AndroidViewModel(application) {

    private lateinit var service: MainService

    val photosSubject: BehaviorSubject<List<Photo>> = BehaviorSubject.create()

    fun setService(service: MainService) {
        this.service = service
    }

    fun getPhotos(): Observable<List<Photo>> {
        return service.getPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext { items ->
                    photosSubject.onNext(items)
                }
    }
}