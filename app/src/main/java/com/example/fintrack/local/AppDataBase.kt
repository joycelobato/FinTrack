package com.example.fintrack.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Expense::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
}