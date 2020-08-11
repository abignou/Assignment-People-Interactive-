package com.abhishek.shaadiassignment.networking

import android.app.Application
import androidx.lifecycle.LiveData
import com.abhishek.shaadiassignment.model.*

class Respository {

    private var mData: LiveData<List<DataListItem>>? = null

    constructor(application: Application) {
        ApiCall.fetchData(ApiClient.API_RESULT)
    }



    fun mLiveData(): LiveData<List<DataListItem>>? {
        mData = ApiCall.mprofilelistData
        return mData
    }


}
