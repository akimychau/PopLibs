package ru.akimychev.poplibs.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.entities.GithubUser
import ru.akimychev.poplibs.model.entities.GithubUserRepos

interface IReposCache {
    fun insertReposToDb(githubUserRepos: List<GithubUserRepos>, githubUser: GithubUser): Completable
    fun getReposFromDb(user: GithubUser): Single<List<GithubUserRepos>>
}