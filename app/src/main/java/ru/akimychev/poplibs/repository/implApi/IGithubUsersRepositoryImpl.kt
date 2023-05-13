package ru.akimychev.poplibs.repository.implApi

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.cache.IUserCache
import ru.akimychev.poplibs.network.connectivityListener.INetworkStatus
import ru.akimychev.poplibs.core.utils.doCompletable
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.network.IDataSource
import ru.akimychev.poplibs.repository.IGithubUsersRepository

class IGithubUsersRepositoryImpl constructor(
    private val api: IDataSource,
    private val networkStatus: INetworkStatus,
    private val cache: IUserCache,
) : IGithubUsersRepository {

    override fun getUsers(): Single<List<GithubUser>> {

        return networkStatus.isOnlineSingle().flatMap { hasConnection ->
            if (hasConnection) {
                api.getAllUsers()
                    .doCompletable {
                        cache.insertUsersToDb(it)
                    }
            } else {
                cache.getUsersFromDb()
            }
        }
    }
}