package ru.akimychev.poplibs.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface UserReposApi {

    @GET
    fun getRepos(@Url url: String): Single<List<UserReposDto>>
}