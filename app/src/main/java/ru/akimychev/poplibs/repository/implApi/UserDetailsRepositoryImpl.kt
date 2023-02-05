package ru.akimychev.poplibs.repository.implApi

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.core.mapper.RepoMapper
import ru.akimychev.poplibs.model.UserRepos
import ru.akimychev.poplibs.network.UserReposApi
import ru.akimychev.poplibs.repository.UserDetailsRepository

class UserDetailsRepositoryImpl constructor(
    private val userReposApi: UserReposApi
) : UserDetailsRepository {

    override fun getRepos(login: String): Single<List<UserRepos>> {
        return userReposApi.getRepos(login)
            .map { it.map(RepoMapper::mapToEntity) }
    }
}