package com.abhishek.shaadiassignment.networking

import com.abhishek.shaadiassignment.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("api/")
    fun getallProfiles(@Query("results") result: String): Observable<DemoApiResult>


}