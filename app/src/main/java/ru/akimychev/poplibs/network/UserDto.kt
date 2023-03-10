package ru.akimychev.poplibs.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserDto(
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("login")
    val login: String,
    @Expose
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @Expose
    @SerializedName("repos_url")
    val reposUrl: String
)
