package com.hansandroid.grospasswd.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hansandroid.grospasswd.di.ViewModelKey
import com.hansandroid.grospasswd.ui.MainActivityViewModel
import com.hansandroid.grospasswd.ui.ViewModelFactory
import com.hansandroid.grospasswd.ui.accountdetail.AccountDetailViewModel
import com.hansandroid.grospasswd.ui.accounts.AccountsViewModel
import com.hansandroid.grospasswd.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AccountsViewModel::class)
    abstract fun bindAccountsListViewModel(viewModel: AccountsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AccountDetailViewModel::class)
    abstract fun bindAccountDetailViewModel(viewModel: AccountDetailViewModel): ViewModel

}