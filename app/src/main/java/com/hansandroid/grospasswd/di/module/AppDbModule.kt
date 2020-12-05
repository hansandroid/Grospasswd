package com.hansandroid.grospasswd.di.module

import android.content.Context
import com.hansandroid.grospasswd.data.AccountsDao
import com.hansandroid.grospasswd.data.AccountsRepo
import com.hansandroid.grospasswd.data.createAccountsDao
import com.hansandroid.grospasswd.di.PerApplication
import dagger.Module
import dagger.Provides

@Module
class AppDbModule {

    @PerApplication
    @Provides
    fun provideAccountsDao(context: Context) = createAccountsDao(context)

    @PerApplication
    @Provides
    fun provideAccountsRepository(accountsDao: AccountsDao) = AccountsRepo(accountsDao)

}