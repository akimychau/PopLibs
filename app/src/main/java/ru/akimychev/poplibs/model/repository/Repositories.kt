package ru.akimychev.poplibs.model.repository

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.entities.GithubUser
import ru.akimychev.poplibs.model.entities.GithubUserRepos

fun interface IGithubUsersRepository {
    fun getUsers(): Single<List<GithubUser>>
}

fun interface IGithubUserReposRepository {
    fun getRepos(user: GithubUser): Single<List<GithubUserRepos>>
}