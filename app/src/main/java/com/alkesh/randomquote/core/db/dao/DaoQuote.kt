package com.alkesh.randomquote.core.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.alkesh.randomquote.core.db.entity.DbQuote

@Dao
interface DaoQuote {
    @Query("SELECT * FROM quote")
    suspend fun getAll(): List<DbQuote>

    @Insert
    suspend fun insertAll(vararg users: DbQuote)

    @Delete
    suspend fun delete(user: DbQuote)


}