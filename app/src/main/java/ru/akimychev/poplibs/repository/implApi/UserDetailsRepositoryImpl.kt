package ru.akimychev.poplibs.repository.implApi

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.core.mapper.UserMapper
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.network.UsersApi
import ru.akimychev.poplibs.repository.UserDetailsRepository

class UserDetailsRepositoryImpl constructor(
    private val usersApi: UsersApi
) : UserDetailsRepository {

    override fun getLogin(login: String): Single<GithubUser> {
        return usersApi.getUser(login)
            .map(UserMapper::mapToEntity)
    }
}