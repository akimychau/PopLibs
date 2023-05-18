package ru.akimychev.poplibs.model.repository.impl

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.cache.IReposCache
import ru.akimychev.poplibs.model.network.connectivityListener.INetworkStatus
import ru.akimychev.poplibs.core.utils.doCompletable
import ru.akimychev.poplibs.model.entities.GithubUser
import ru.akimychev.poplibs.model.entities.GithubUserRepos
import ru.akimychev.poplibs.model.network.IDataSource
import ru.akimychev.poplibs.model.repository.IGithubUserReposRepository

class githubUserReposRepositoryImpl constructor(
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