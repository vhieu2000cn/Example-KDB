package com.example.exampledb.android

import android.app.Application
import com.example.exampledb.android.di.appModule
import com.example.exampledb.di.shareModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(androidContext = this@MainApplication)
            modules(shareModule + appModule)
        }
    }
}