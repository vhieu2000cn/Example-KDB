package com.example.exampledb.di

import com.example.exampledb.HttpApi
import com.example.exampledb.cache.Database
import org.koin.dsl.module

val shareModule = module {
    single { HttpApi() }
    single { Database(get()) }
}