package com.abhishek.shaadiassignment.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName


@Entity
data class ID(

//        @SerializedName("id")
//        @PrimaryKey
        var id: Int = -1,

        @SerializedName("name")
        @ColumnInfo(name = "name")
        var name: String,
        @SerializedName("value")
        @ColumnInfo(name = "value")
        var value: String

)