package ru.akimychev.poplibs.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.network.GithubUserDto

interface IUserCache {
    fun insertUsersToDb(githubUserDto: List<GithubUserDto>): Completable
    fun getUsersFromDb(): Single<List<GithubUser>>
}