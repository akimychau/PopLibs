package ru.akimychev.poplibs.di.repos.module

import dagger.Module
import dagger.Provides
import ru.akimychev.poplibs.model.cache.IReposCache
import ru.akimychev.poplibs.model.cache.RoomReposCache
import ru.akimychev.poplibs.model.database.GithubAppDb
import ru.akimychev.poplibs.model.network.IDataSource
import ru.akimychev.poplibs.model.network.connectivityListener.INetworkStatus
import ru.akimychev.poplibs.model.repository.IGithubUserReposRepository
import ru.akimychev.poplibs.model.repository.impl.githubUserReposRepositoryImpl

@Module
class ReposModule {

    @Provides
    fun userDetailsRepository(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IReposCache,
    ): IGithubUserReposRepository = githubUserReposRepositoryImpl(api, networkStatus, cache)

    @Provides
    fun reposCache(db: GithubAppDb): IReposCache {
        return RoomReposCache(db)
    }
}