package com.hansandroid.grospasswd

import android.app.Application
import android.content.Context
import com.hansandroid.grospasswd.di.component.DaggerAppComponent
import com.hansandroid.grospasswd.di.module.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class GrosspaswdApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        val appModule = AppModule(this)
        DaggerAppComponent.builder().setAppModule(appModule).build().inject(this)
    }


}