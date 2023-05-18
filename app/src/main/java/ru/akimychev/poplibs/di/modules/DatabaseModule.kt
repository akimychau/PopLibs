package ru.akimychev.poplibs.di.modules

import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.akimychev.poplibs.App
import ru.akimychev.poplibs.model.database.GithubAppDb
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun database(app: App) = Room.databaseBuilder(app, GithubAppDb::class.java,
        GithubAppDb.DB_NAME).build()
}