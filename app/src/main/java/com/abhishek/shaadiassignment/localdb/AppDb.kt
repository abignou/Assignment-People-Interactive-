package com.abhishek.shaadiassignment.localdb

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.abhishek.shaadiassignment.localdb.converter.DOBDataconverter
import com.abhishek.shaadiassignment.localdb.converter.IDDataconverter
import com.abhishek.shaadiassignment.localdb.converter.LocationDataconverter
import com.abhishek.shaadiassignment.localdb.converter.NameDataconverter
import com.abhishek.shaadiassignment.model.DataListItemtoDB
import com.abhishek.shaadiassignment.localdb.converter.PictureDataconverter

@Database(entities = [(DataListItemtoDB::class)],version = 1,exportSchema = false)
@TypeConverters(
    NameDataconverter::class, LocationDataconverter::class, DOBDataconverter::class,
    IDDataconverter::class, PictureDataconverter::class)
abstract class AppDb : RoomDatabase() {

    abstract fun saveDao(): SaveDao
    companion object {

        private var INSTANCE: AppDb? = null

        fun getInstance(context: Context): AppDb {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDb::class.java, "Demo").build()
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}