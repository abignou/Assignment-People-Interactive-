package com.abhishek.shaadiassignment.localdb.converter

import androidx.room.TypeConverter
import android.text.TextUtils
import com.abhishek.shaadiassignment.model.Dob
import com.google.gson.Gson


class DOBDataconverter {
        @TypeConverter
        public fun stringToDobItem(string: String): Dob? {
                if (TextUtils.isEmpty(string)){
                }
                return Gson().fromJson(string, Dob::class.java)
        }

        @TypeConverter
        public fun dobItemToString(dob: Dob): String {
                return Gson().toJson(dob)
        }
}