package ru.akimychev.poplibs.di.modules

import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.akimychev.poplibs.App
import ru.akimychev.poplibs.cache.IReposCache
import ru.akimychev.poplibs.cache.IUserCache
import ru.akimychev.poplibs.cache.RoomReposCache
import ru.akimychev.poplibs.cache.RoomUserCache
import ru.akimychev.poplibs.database.GithubAppDb
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun database(app: App) = Room.databaseBuilder(app, GithubAppDb::class.java,
        GithubAppDb.DB_NAME).build()

    @Singleton
    @Provides
    fun usersCache(db: GithubAppDb): IUserCache {
        return RoomUserCache(db)
    }

    @Singleton
    @Provides
    fun reposCache(db: GithubAppDb): IReposCache {
        return RoomReposCache(db)
    }
}