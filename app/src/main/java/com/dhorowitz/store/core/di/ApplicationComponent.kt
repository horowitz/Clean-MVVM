package com.dhorowitz.store.core.di

import com.dhorowitz.store.core.StoreApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        NetworkModule::class,
        BuildersModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: StoreApp) : Builder
        fun build() : ApplicationComponent
    }

    fun inject(app: StoreApp)
}