package com.hansandroid.grospasswd.di.component

import com.hansandroid.grospasswd.GrosspaswdApplication
import com.hansandroid.grospasswd.di.PerApplication
import com.hansandroid.grospasswd.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@PerApplication
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppDbModule::class,
        ViewModelModule::class,
        ActivityModuleBuilder::class,
        FragmentsModuleBuilder::class,
        AppModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun setAppModule(appModule: AppModule): Builder
    }

    fun inject(app: GrosspaswdApplication)
}