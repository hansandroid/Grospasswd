package com.hansandroid.grospasswd.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(): ViewModel() {

    val mainPassword = MutableLiveData<String>()

}