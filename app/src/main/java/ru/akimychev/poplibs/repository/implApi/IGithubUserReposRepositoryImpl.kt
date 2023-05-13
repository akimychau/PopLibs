package ru.akimychev.poplibs.repository.implApi

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.cache.IReposCache
import ru.akimychev.poplibs.network.connectivityListener.INetworkStatus
import ru.akimychev.poplibs.core.utils.doCompletable
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.GithubUserRepos
import ru.akimychev.poplibs.network.IDataSource
import ru.akimychev.poplibs.repository.IGithubUserReposRepository

class IGithubUserReposRepositoryImpl constructor(
    private val api: IDataSource,
    private val networkStatus: INetworkStatus,
    private val cache: IReposCache,
) : IGithubUserReposRepository {

    override fun getRepos(user: GithubUser): Single<List<GithubUserRepos>> {
        return networkStatus.isOnlineSingle().flatMap { hasConnection ->
            if (hasConnection) {
                api.getRepos(user.reposUrl)
                    .doCompletable {
                        cache.insertReposToDb(it, user)
                    }
            } else {
                cache.getReposFromDb(user)
            }
        }
    }
}