package ru.akimychev.poplibs.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.GithubUserRepos
import ru.akimychev.poplibs.network.GithubUserReposDto

interface IRepositoriesCache {
    fun insertReposToDb(githubUserReposDto: List<GithubUserReposDto>, githubUser: GithubUser): Completable
    fun getReposFromDb(user: GithubUser): Single<List<GithubUserRepos>>
}