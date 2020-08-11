package com.abhishek.shaadiassignment.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity (tableName = "dataListItem")
data class DataListItemtoDB(
//        @SerializedName("id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int = -1,
    @SerializedName("gender")
    @ColumnInfo(name = "gender")
    var gender: String,
    @ColumnInfo(name = "actionStatus")
    var actionStatus: Int,
    @SerializedName("name")
    @ColumnInfo(name = "name")
    var name: Name?,
    @SerializedName("location")
    @ColumnInfo(name = "location")
    var location: Location,
    @SerializedName("email")
    @ColumnInfo(name = "email")
    var email: String,
    @SerializedName("dob")
    @ColumnInfo(name = "dob")
    var dob: Dob,
    @SerializedName("phone")
    @ColumnInfo(name = "phone")
    var phone: String,
    @SerializedName("cell")
    @ColumnInfo(name = "cell")
    var cell: String,
    @SerializedName("id")
    @ColumnInfo(name = "objid")
    var objid: ID,
    @SerializedName("picture")
    @ColumnInfo(name = "picture")
    var picture: Picture,
    @SerializedName("nat")
    @ColumnInfo(name = "nat")
    var nat: String
)