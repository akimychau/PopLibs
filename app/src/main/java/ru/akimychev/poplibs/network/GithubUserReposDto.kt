package ru.akimychev.poplibs.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GithubUserReposDto(
    @Expose
    @SerializedName("id")
    val id: Long,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("forks_count")
    val forksCount: Int,
)
