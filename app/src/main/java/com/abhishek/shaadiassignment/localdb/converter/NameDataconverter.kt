package com.abhishek.shaadiassignment.localdb.converter

import androidx.room.TypeConverter
import android.text.TextUtils
import com.abhishek.shaadiassignment.model.Name
import com.google.gson.Gson


class NameDataconverter {
        @TypeConverter
        public fun stringToNameItem(string: String): Name? {
                if (TextUtils.isEmpty(string)){
                }
                return Gson().fromJson(string, Name::class.java)
        }

        @TypeConverter
        public fun nameItemToString(name: Name): String {
                return Gson().toJson(name)
        }
}