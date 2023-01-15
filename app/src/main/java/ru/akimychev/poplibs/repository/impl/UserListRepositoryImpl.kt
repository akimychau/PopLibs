package ru.akimychev.poplibs.repository.impl

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.repository.UserListRepository

class UserListRepositoryImpl : UserListRepository {

    private val repositories = listOf(
        GithubUser("Cat"),
        GithubUser("Dog"),
        GithubUser("Mouse"),
        GithubUser("Pig"),
        GithubUser("Rat")
    )

    override fun getUsers(): Single<List<GithubUser>> {
        return Single.create {
            it.onSuccess(repositories)
        }
    }
}