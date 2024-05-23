package com.example.fintrack

import android.app.Application
import androidx.room.Room
import com.example.fintrack.local.AppDataBase

class FinTrackApplication: Application() {
    private lateinit var dataBase: AppDataBase

    override fun onCreate() {
        super.onCreate()
        dataBase = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java, "Fintrack-database"
        ).build()
    }

    fun getAppDataBase(): AppDataBase {
        return dataBase
    }
}
