package ru.akimychev.poplibs.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser(
    val id: Long,
    val login: String,
    val userAvatar: String?,
    val reposUrl: String
) : Parcelable