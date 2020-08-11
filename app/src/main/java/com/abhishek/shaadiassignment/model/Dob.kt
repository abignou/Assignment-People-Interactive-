package com.abhishek.shaadiassignment.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName


@Entity
data class Dob(

//        @SerializedName("id")
//        @PrimaryKey
        var id: Int = -1,

        @SerializedName("age")
        @ColumnInfo(name = "age")
        var age: String,
        @SerializedName("date")
        @ColumnInfo(name = "date")
        var date: String

)