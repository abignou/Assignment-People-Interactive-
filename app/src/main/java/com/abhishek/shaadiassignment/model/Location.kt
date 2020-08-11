package com.abhishek.shaadiassignment.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName


@Entity
data class Location(

//        @SerializedName("id")
//        var id: Int = -1,

        @SerializedName("city")
        @ColumnInfo(name = "city")
        var city: String,
        @SerializedName("state")
        @ColumnInfo(name = "state")
        var state: String,
        @SerializedName("country")
        @ColumnInfo(name = "country")
        var country: String
)