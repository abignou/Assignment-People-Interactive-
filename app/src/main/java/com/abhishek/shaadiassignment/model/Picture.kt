package com.abhishek.shaadiassignment.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName



@Entity
data class Picture(

//        @SerializedName("id")
        /*@PrimaryKey
        var id: Int = -1,
*/
        @SerializedName("large")
        @ColumnInfo(name = "large")
        var large: String,
        @SerializedName("medium")
        @ColumnInfo(name = "medium")
        var medium: String,
        @SerializedName("thumbnail")
        @ColumnInfo(name = "thumbnail")
        var thumbnail: String
)