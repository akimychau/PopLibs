package ru.akimychev.poplibs.model.repository.impl

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.cache.IUserCache
import ru.akimychev.poplibs.model.network.connectivityListener.INetworkStatus
import ru.akimychev.poplibs.core.utils.doCompletable
import ru.akimychev.poplibs.model.entities.GithubUser
import ru.akimychev.poplibs.model.network.IDataSource
import ru.akimychev.poplibs.model.repository.IGithubUsersRepository

class githubUsersRepositoryImpl constructor(
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