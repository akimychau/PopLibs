package ru.akimychev.poplibs.repository.implApi

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.cache.RoomRepositoriesCache
import ru.akimychev.poplibs.core.connectivityListener.NetworkStatus
import ru.akimychev.poplibs.core.mapper.RepoMapper
import ru.akimychev.poplibs.core.utils.doCompletable
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.GithubUserRepos
import ru.akimychev.poplibs.network.GithubUserReposApi
import ru.akimychev.poplibs.repository.UserDetailsRepository

class UserDetailsRepositoryImpl constructor(
    private val githubUserReposApi: GithubUserReposApi,
    private val networkStatus: NetworkStatus,
    private val cache: RoomRepositoriesCache,
) : UserDetailsRepository {

    override fun getRepos(user: GithubUser): Single<List<GithubUserRepos>> {
        return networkStatus.isOnlineSingle().flatMap { hasConnection ->
            if (hasConnection) {
                fetchFromApi(user)
            } else {
                cache.getReposFromDb(user)
            }
        }
    }

    private fun fetchFromApi(user: GithubUser): Single<List<GithubUserRepos>> {
        return githubUserReposApi.getRepos(user.reposUrl)
            .doCompletable {
                cache.insertReposToDb(it, user)
            }
            .map { it.map(RepoMapper::mapDtoToEntity) }
    }
}