package com.hansandroid.grospasswd.data

import androidx.annotation.WorkerThread
import com.hansandroid.grospasswd.model.AccountEntity
import kotlinx.coroutines.flow.Flow

class AccountsRepo(
    private val accountsDao: AccountsDao
) {

    val allAccounts: Flow<List<AccountEntity>> = accountsDao.getAllAccounts()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(account: AccountEntity) {
        accountsDao.insertOrUpdate(account)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(account: AccountEntity) {
        accountsDao.delete(account)
    }

    fun findAccountById(id: Long): Flow<AccountEntity> {
        return accountsDao.findAccountById(id)
    }

}