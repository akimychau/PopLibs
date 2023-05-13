package ru.akimychev.poplibs.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.GithubUserRepos

interface IReposCache {
    fun insertReposToDb(githubUserRepos: List<GithubUserRepos>, githubUser: GithubUser): Completable
    fun getReposFromDb(user: GithubUser): Single<List<GithubUserRepos>>
}