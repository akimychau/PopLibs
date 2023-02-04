package ru.akimychev.poplibs.repository.implLocal

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.repository.UserListRepository

class UserListRepositoryImplLocal : UserListRepository {

    private val repositories = listOf(
        GithubUser("Cat", "1", "qwe"),
        GithubUser("Dog", "2", "qwe"),
        GithubUser("Mouse", "3", "qwe"),
        GithubUser("Pig", "4", "qwe"),
        GithubUser("Rat", "5", "QWE")
    )

    override fun getUsers(): Single<List<GithubUser>> {
        return Single.create {
            it.onSuccess(repositories)
        }
    }
}