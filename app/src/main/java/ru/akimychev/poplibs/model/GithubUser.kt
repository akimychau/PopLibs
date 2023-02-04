package ru.akimychev.poplibs.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser(
    val login: String,
    val id: String,
    val userAvatar: String?
) : Parcelable