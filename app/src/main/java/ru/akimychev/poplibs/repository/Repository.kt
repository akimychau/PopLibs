package ru.akimychev.poplibs.repository

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.GithubUser

fun interface UserListRepository {

    fun getUsers(): Single<List<GithubUser>>
}

fun interface UserDetailsRepository {

    fun getLogin(login: String): Single<GithubUser>
}