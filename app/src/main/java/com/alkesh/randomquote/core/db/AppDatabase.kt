package com.alkesh.randomquote.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alkesh.randomquote.core.db.dao.DaoQuote
import com.alkesh.randomquote.core.db.entity.DbQuote

@Database(entities = [DbQuote::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun quoteDao(): DaoQuote
}