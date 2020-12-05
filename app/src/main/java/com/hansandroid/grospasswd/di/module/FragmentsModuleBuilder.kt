package com.hansandroid.grospasswd.di.module

import com.hansandroid.grospasswd.ui.accountdetail.AccountDetailFragment
import com.hansandroid.grospasswd.ui.accounts.AccountsListFragment
import com.hansandroid.grospasswd.ui.auth.AuthFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModuleBuilder {

    @ContributesAndroidInjector()
    abstract fun contributeAuthFragment(): AuthFragment

    @ContributesAndroidInjector()
    abstract fun contributeAccountsLIstFragment(): AccountsListFragment

    @ContributesAndroidInjector()
    abstract fun contributeAccountDetailFragment(): AccountDetailFragment

}