package ru.akimychev.poplibs.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.entities.GithubUser

interface IUserCache {
    fun insertUsersToDb(githubUser: List<GithubUser>): Completable
    fun getUsersFromDb(): Single<List<GithubUser>>
}