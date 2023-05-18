package ru.akimychev.poplibs.di.user.module

import dagger.Module
import dagger.Provides
import ru.akimychev.poplibs.model.cache.IUserCache
import ru.akimychev.poplibs.model.cache.RoomUserCache
import ru.akimychev.poplibs.model.database.GithubAppDb
import ru.akimychev.poplibs.di.user.UserScope
import ru.akimychev.poplibs.model.network.IDataSource
import ru.akimychev.poplibs.model.network.connectivityListener.INetworkStatus
import ru.akimychev.poplibs.model.repository.IGithubUsersRepository
import ru.akimychev.poplibs.model.repository.impl.githubUsersRepositoryImpl

@Module
class UserModule {

    @UserScope
    @Provides
    fun userListRepository(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IUserCache,
    ): IGithubUsersRepository = githubUsersRepositoryImpl(api, networkStatus, cache)

    @Provides
    fun usersCache(db: GithubAppDb): IUserCache {
        return RoomUserCache(db)
    }
}