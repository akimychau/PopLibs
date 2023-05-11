package ru.akimychev.poplibs.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url
import ru.akimychev.poplibs.model.GithubUserRepos

interface GithubUserReposApi {

    @GET
    fun getRepos(@Url url: String): Single<List<GithubUserRepos>>
}