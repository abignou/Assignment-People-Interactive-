package com.abhishek.shaadiassignment.localdb.converter

import androidx.room.TypeConverter
import android.text.TextUtils
import com.abhishek.shaadiassignment.model.Location
import com.google.gson.Gson


class LocationDataconverter {
        @TypeConverter
        public fun stringToLocationItem(string: String): Location? {
                if (TextUtils.isEmpty(string)){
                }
                return Gson().fromJson(string, Location::class.java)
        }

        @TypeConverter
        public fun locationItemToString(loc: Location): String {
                return Gson().toJson(loc)
        }
}