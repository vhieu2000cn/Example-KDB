package com.example.exampledb.android.di

import com.example.exampledb.cache.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { DatabaseDriverFactory(androidContext()) }
}