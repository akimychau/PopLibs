package ru.akimychev.poplibs.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repo(
    val name: String
) : Parcelable