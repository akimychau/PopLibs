package ru.akimychev.poplibs.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class RoomGithubUser(
    @PrimaryKey
    val id: Long,
    val login: String,
    val avatarUrl: String?,
    val reposUrl: String
)
