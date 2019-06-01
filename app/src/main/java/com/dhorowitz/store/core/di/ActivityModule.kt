package com.dhorowitz.store.core.di

import android.app.Activity
import com.dhorowitz.store.core.Navigator
import com.dhorowitz.store.core.NavigatorImpl
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun provideNavigator(activity: Activity): Navigator =
            NavigatorImpl(activity)
    }
}