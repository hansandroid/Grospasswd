package com.hansandroid.grospasswd.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class AccountEntity(
    @PrimaryKey(autoGenerate = true) var id: Long,
    @ColumnInfo(name = "account") val name: String
) {
    constructor(account: String) : this(0, account)

    fun isValidForAdd() = name.trim().isNotEmpty()

}