package com.abhishek.shaadiassignment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.abhishek.shaadiassignment.networking.Respository
import com.abhishek.shaadiassignment.model.DataListItem

class MainActivityViewModel : AndroidViewModel {

    private var mData: LiveData<List<DataListItem>>? = null
    private val mRespository: Respository

    constructor(application: Application) : super(application){
        mRespository = Respository(application)
    }

    fun mLiveData(): LiveData<List<DataListItem>>? {
        mData = mRespository.mLiveData()
        return mData
    }

}
