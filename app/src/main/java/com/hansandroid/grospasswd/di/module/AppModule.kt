package com.hansandroid.grospasswd.di.module

import android.content.Context
import com.hansandroid.grospasswd.di.PerApplication
import com.hansandroid.grospasswd.model.PasswordProvider
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val appContext: Context) {

    @PerApplication
    @Provides
    fun provideAppContext() = appContext

    @PerApplication
    @Provides
    fun providePasswordProvider() = PasswordProvider()

}