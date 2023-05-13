package ru.akimychev.poplibs.di.modules

import dagger.Module
import dagger.Provides
import ru.akimychev.poplibs.cache.IReposCache
import ru.akimychev.poplibs.cache.IUserCache
import ru.akimychev.poplibs.network.connectivityListener.INetworkStatus
import ru.akimychev.poplibs.network.IDataSource
import ru.akimychev.poplibs.repository.IGithubUserReposRepository
import ru.akimychev.poplibs.repository.IGithubUsersRepository
import ru.akimychev.poplibs.repository.implApi.IGithubUserReposRepositoryImpl
import ru.akimychev.poplibs.repository.implApi.IGithubUsersRepositoryImpl
import javax.inject.Singleton

@Module
class RepositoriesModule {

    @Singleton
    @Provides
    fun userListRepository(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IUserCache,
    ): IGithubUsersRepository = IGithubUsersRepositoryImpl(api, networkStatus, cache)

    @Singleton
    @Provides
    fun userDetailsRepository(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IReposCache,
    ): IGithubUserReposRepository = IGithubUserReposRepositoryImpl(api, networkStatus, cache)
}