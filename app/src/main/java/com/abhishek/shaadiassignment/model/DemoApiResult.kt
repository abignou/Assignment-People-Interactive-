package com.abhishek.shaadiassignment.model

import com.google.gson.annotations.SerializedName

class DemoApiResult {
    var page: Int = 0
    @SerializedName("results")
    lateinit var results: List<DataListItem>
}


