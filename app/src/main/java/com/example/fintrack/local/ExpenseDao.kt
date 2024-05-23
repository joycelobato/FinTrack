package com.example.fintrack.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(despesa: Expense)

    @Query("Select * from despesa")
    fun getAll(): LiveData<List<Expense>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(despesa: Expense)

    /*//Deletando todos
    @Query("DELETE from task")
    suspend fun deleteAll()
    */
    //Deletando por id
    @Query("DELETE from despesa WHERE id =:id")
    suspend fun deleteById(id: Int)

}