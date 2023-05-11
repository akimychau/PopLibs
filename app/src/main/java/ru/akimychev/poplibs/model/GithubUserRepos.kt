package ru.akimychev.poplibs.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@kotlinx.parcelize.Parcelize
data class GithubUserRepos(
    @Expose
    @SerializedName("id")
    val id: Long,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("forks_count")
    val forksCount: Int,
) : Parcelable