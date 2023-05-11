package ru.akimychev.poplibs.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.GithubUser

interface IUserCache {
    fun insertUsersToDb(githubUser: List<GithubUser>): Completable
    fun getUsersFromDb(): Single<List<GithubUser>>
}