package ru.akimychev.poplibs.repository.implApi

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.core.mapper.UserMapper
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.network.GithubUserApi
import ru.akimychev.poplibs.repository.UserListRepository

class UserListRepositoryImpl constructor(
    private val githubUserApi: GithubUserApi
) : UserListRepository {

    override fun getUsers(): Single<List<GithubUser>> {
        return githubUserApi.getAllUsers()
            .map { it.map(UserMapper::mapDtoToEntity) }
    }
}