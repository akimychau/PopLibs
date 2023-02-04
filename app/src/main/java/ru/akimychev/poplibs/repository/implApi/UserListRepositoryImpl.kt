package ru.akimychev.poplibs.repository.implApi

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.core.mapper.UserMapper
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.network.UsersApi
import ru.akimychev.poplibs.repository.UserListRepository

class UserListRepositoryImpl constructor(
    private val usersApi: UsersApi
) : UserListRepository {

    override fun getUsers(): Single<List<GithubUser>> {
        return usersApi.getAllUsers()
            .map { it.map(UserMapper::mapToEntity) }
    }
}