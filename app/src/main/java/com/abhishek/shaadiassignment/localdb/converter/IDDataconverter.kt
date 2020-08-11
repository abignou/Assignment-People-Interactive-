package com.abhishek.shaadiassignment.localdb.converter

import androidx.room.TypeConverter
import android.text.TextUtils
import com.abhishek.shaadiassignment.model.ID
import com.google.gson.Gson


class IDDataconverter {
        @TypeConverter
        public fun stringToIDItem(string: String): ID? {
                if (TextUtils.isEmpty(string)){
                }
                return Gson().fromJson(string, ID::class.java)
        }

        @TypeConverter
        public fun idItemToString(id: ID): String {
                return Gson().toJson(id)
        }
}