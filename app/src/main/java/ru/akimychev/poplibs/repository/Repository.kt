package ru.akimychev.poplibs.repository

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.UserRepos

fun interface UserListRepository {
    fun getUsers(): Single<List<GithubUser>>
}

fun interface UserDetailsRepository {
    fun getRepos(login: String): Single<List<UserRepos>>
}