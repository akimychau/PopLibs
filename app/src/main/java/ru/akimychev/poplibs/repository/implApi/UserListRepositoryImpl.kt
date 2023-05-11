package ru.akimychev.poplibs.repository.implApi

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.cache.RoomUserCache
import ru.akimychev.poplibs.core.connectivityListener.NetworkStatus
import ru.akimychev.poplibs.core.utils.doCompletable
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.network.GithubUserApi
import ru.akimychev.poplibs.repository.UserListRepository

class UserListRepositoryImpl constructor(
    private val githubUserApi: GithubUserApi,
    private val networkStatus: NetworkStatus,
    private val cache: RoomUserCache,
) : UserListRepository {

    override fun getUsers(): Single<List<GithubUser>> {

        return networkStatus.isOnlineSingle().flatMap { hasConnection ->
            if (hasConnection) {
                githubUserApi.getAllUsers()
                    .doCompletable {
                        cache.insertUsersToDb(it)
                    }
            } else {
                cache.getUsersFromDb()
            }
        }
    }
}