package ru.akimychev.poplibs.repository.implApi

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.core.mapper.RepoMapper
import ru.akimychev.poplibs.model.GithubUserRepos
import ru.akimychev.poplibs.network.GithubUserReposApi
import ru.akimychev.poplibs.repository.UserDetailsRepository

class UserDetailsRepositoryImpl constructor(
    private val githubUserReposApi: GithubUserReposApi
) : UserDetailsRepository {

    override fun getRepos(login: String): Single<List<GithubUserRepos>> {
        return githubUserReposApi.getRepos(login)
            .map { it.map(RepoMapper::mapDtoToEntity) }
    }
}