package com.abhishek.shaadiassignment.localdb.converter

import androidx.room.TypeConverter
import android.text.TextUtils
import com.abhishek.shaadiassignment.model.Picture
import com.google.gson.Gson


class PictureDataconverter {
        @TypeConverter
        public fun stringToPicItem(string: String): Picture? {
                if (TextUtils.isEmpty(string)){
                }
                return Gson().fromJson(string, Picture::class.java)
        }

        @TypeConverter
        public fun picItemToString(pic: Picture): String {
                return Gson().toJson(pic)
        }
}