package com.example.hw_5_5.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw_5_5.remote.LoveModel

class AppDataBase {
    @Database(entities = [LoveModel::class], version = 1)
    abstract class AppDataBase:RoomDatabase() {
        abstract fun getDao():LoveDao
    }
}