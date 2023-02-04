package ru.akimychev.poplibs.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ReposApi {

    @GET("/users/{login}/repos")
    fun getRepos(@Path("login") login: String): Single<List<ReposDto>>
}