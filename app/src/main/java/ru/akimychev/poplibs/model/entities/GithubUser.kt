package ru.akimychev.poplibs.model.entities

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@kotlinx.parcelize.Parcelize
data class GithubUser(
    @Expose
    @SerializedName("id")
    val id: Long,
    @Expose
    @SerializedName("login")
    val login: String,
    @Expose
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    @Expose
    @SerializedName("repos_url")
    val reposUrl: String,
) : Parcelable