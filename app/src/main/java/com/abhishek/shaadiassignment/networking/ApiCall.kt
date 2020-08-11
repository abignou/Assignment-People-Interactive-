package com.abhishek.shaadiassignment.networking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abhishek.shaadiassignment.model.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

object ApiCall {

    private val data = MutableLiveData<List<DataListItem>>()

    private var mListObservable: Observable<DemoApiResult>? = null

    private val compositeDisposable = CompositeDisposable()


    val mprofilelistData: LiveData<List<DataListItem>>
        get() = data

    fun fetchData(result: String) {

        val apiService = ApiClient.client?.create(ApiInterface::class.java)

        mListObservable = apiService?.getallProfiles(result)
        compositeDisposable.add(mListObservable!!.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<DemoApiResult>() {
                override fun onNext(mdata: DemoApiResult) {
                    val results = mdata.results
                    data.postValue(results)
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }
            })
        )
    }



}