package ru.akimychev.poplibs.repository

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.GithubUserRepos

fun interface IGithubUsersRepository {
    fun getUsers(): Single<List<GithubUser>>
}

fun interface IGithubUserReposRepository {
    fun getRepos(user: GithubUser): Single<List<GithubUserRepos>>
}