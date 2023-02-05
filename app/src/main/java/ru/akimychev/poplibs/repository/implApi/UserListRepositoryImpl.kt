package ru.akimychev.poplibs.repository.implApi

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.core.mapper.UserMapper
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.network.UserApi
import ru.akimychev.poplibs.repository.UserListRepository

class UserListRepositoryImpl constructor(
    private val userApi: UserApi
) : UserListRepository {

    override fun getUsers(): Single<List<GithubUser>> {
        return userApi.getAllUsers()
            .map { it.map(UserMapper::mapToEntity) }
    }
}