package com.hansandroid.grospasswd.ui.accounts

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.hansandroid.grospasswd.model.AccountEntity
import com.hansandroid.grospasswd.data.AccountsRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountsViewModel @Inject constructor(
    private val repository: AccountsRepo
): ViewModel() {

    val accounts: LiveData<List<AccountEntity>> = repository.allAccounts.asLiveData()

    fun findAccountById(id: Long) = repository.findAccountById(id).asLiveData()

    fun insert(account: String) = viewModelScope.launch {
        repository.insert(AccountEntity(account))
    }

    fun delete(account: AccountEntity) = viewModelScope.launch {
        repository.delete(account)
    }

}