package com.hansandroid.grospasswd.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hansandroid.grospasswd.model.AccountEntity

fun createAccountsDao(context: Context): AccountsDao {
    return Room.databaseBuilder(context, AccountsDatabase::class.java, "accountsdb")
        .build().accountsDao()
}

@Database(entities = [AccountEntity::class], version = 1, exportSchema = false)
abstract class AccountsDatabase : RoomDatabase() {
    abstract fun accountsDao(): AccountsDao
}