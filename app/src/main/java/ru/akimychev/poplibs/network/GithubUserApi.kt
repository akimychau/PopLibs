package ru.akimychev.poplibs.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface GithubUserApi {

    @GET("/users")
    fun getAllUsers(): Single<List<GithubUserDto>>
}