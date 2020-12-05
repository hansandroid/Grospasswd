package com.hansandroid.grospasswd.di.module

import com.hansandroid.grospasswd.ui.MainActivity
import com.hansandroid.grospasswd.ui.auth.AuthFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModuleBuilder {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

}