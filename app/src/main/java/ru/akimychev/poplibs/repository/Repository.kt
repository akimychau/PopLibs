package ru.akimychev.poplibs.repository

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.Repo

fun interface UserListRepository {

    fun getUsers(): Single<List<GithubUser>>
}

interface UserDetailsRepository {

    fun getLogin(login: String): Single<GithubUser>
    fun getRepos(login: String): Single<List<Repo>>

}