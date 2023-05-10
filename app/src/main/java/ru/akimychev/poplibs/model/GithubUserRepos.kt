package ru.akimychev.poplibs.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUserRepos(
    val id: Long,
    val name: String,
    val forksCount: Int
) : Parcelable