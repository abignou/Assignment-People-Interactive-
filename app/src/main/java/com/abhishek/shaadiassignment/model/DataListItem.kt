package com.abhishek.shaadiassignment.model

import com.google.gson.annotations.SerializedName
class DataListItem {


    @SerializedName("gender")
    var gender: String = ""


    @SerializedName("name")
    var name: Name? = null

    @SerializedName("location")
    lateinit var location: Location

    @SerializedName("email")
    var email: String=""

    @SerializedName("dob")
    lateinit var dob: Dob

    @SerializedName("phone")
    var phone: String=""

    @SerializedName("cell")
    var cell: String=""

    @SerializedName("id")
    lateinit var objid: ID

    @SerializedName("picture")
    lateinit var picture: Picture

    @SerializedName("nat")
    var nat: String=""
}