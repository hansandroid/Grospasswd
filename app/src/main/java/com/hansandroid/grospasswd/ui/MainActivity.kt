package com.hansandroid.grospasswd.ui

import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.hansandroid.grospasswd.R
import com.hansandroid.grospasswd.databinding.MainActivityBinding
import com.hansandroid.grospasswd.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

    lateinit var navController: NavController

    private lateinit var binding: MainActivityBinding

    override fun initViewBinding() {
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.nav_host)
    }
}