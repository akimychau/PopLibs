package ru.akimychev.poplibs.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface UserApi {

    @GET("/users")
    fun getAllUsers(): Single<List<UserDto>>
}