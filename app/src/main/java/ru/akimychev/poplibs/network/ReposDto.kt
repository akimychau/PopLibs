package ru.akimychev.poplibs.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ReposDto(
    @Expose
    @SerializedName("name")
    val name: String
)
