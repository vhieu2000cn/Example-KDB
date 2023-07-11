package com.example.exampledb.usecase

import com.example.exampledb.RocketLaunch
import com.example.exampledb.HttpApi
import com.example.exampledb.cache.Database
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetAllDataUseCase : KoinComponent {
    private val database by inject<Database>()
    private val api by inject<HttpApi>()

    suspend operator fun invoke(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearDatabase()
                database.createLaunches(it)
            }
        }
    }
}