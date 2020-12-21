package com.alkesh.randomquote.core.db.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class DbQuote(
    @PrimaryKey @NonNull
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "author") val author: String?,
    @ColumnInfo(name = "en") val en: String?
)