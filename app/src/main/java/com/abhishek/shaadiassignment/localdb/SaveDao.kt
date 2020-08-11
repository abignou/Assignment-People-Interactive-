package com.abhishek.shaadiassignment.localdb

import androidx.room.*
import com.abhishek.shaadiassignment.model.DataListItemtoDB

@Dao
interface SaveDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllData(datalist: List<DataListItemtoDB>):List<Long>

    @Query(value = "Select * from datalistitem")
    fun getAllData() : List<DataListItemtoDB>

    @Update
    fun update(data:DataListItemtoDB)
}