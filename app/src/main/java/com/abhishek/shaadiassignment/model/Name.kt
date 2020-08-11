package com.abhishek.shaadiassignment.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName


@Entity
data class Name constructor(
//        @SerializedName("id")

//        var id: Int = -1,
        @SerializedName("title")
        @ColumnInfo(name = "title")
        var title: String,
        @SerializedName("first")
        @ColumnInfo(name = "first")
        var first: String,
        @SerializedName("last")
        @ColumnInfo(name = "last")
        var last: String
)