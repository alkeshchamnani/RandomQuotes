package com.alkesh.randomquote.core.db

import android.content.Context
import androidx.room.Room

object DbInstance {
    private var roomDatabase: AppDatabase? = null

    fun getInstance(): AppDatabase? {
        return roomDatabase
    }
    @JvmStatic
    fun initDatabase(applicationContext: Context) {
        if (roomDatabase == null) {
            roomDatabase = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "quotes"
            ).build()
        }

    }

}