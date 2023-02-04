package ru.akimychev.poplibs.repository.implApi

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.core.mapper.RepoMapper
import ru.akimychev.poplibs.core.mapper.UserMapper
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.Repo
import ru.akimychev.poplibs.network.ReposApi
import ru.akimychev.poplibs.network.UsersApi
import ru.akimychev.poplibs.repository.UserDetailsRepository

class UserDetailsRepositoryImpl constructor(
    private val usersApi: UsersApi,
    private val reposApi: ReposApi
) : UserDetailsRepository {

    override fun getLogin(login: String): Single<GithubUser> {
        return usersApi.getUser(login)
            .map(UserMapper::mapToEntity)
    }

    override fun getRepos(login: String): Single<List<Repo>> {
        return reposApi.getRepos(login)
            .map { it.map(RepoMapper::mapToEntity2) }
    }
}