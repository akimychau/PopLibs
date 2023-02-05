package ru.akimychev.poplibs.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserRepos(
    val name: String
) : Parcelable