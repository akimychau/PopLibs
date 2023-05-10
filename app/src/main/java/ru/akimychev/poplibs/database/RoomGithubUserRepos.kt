package ru.akimychev.poplibs.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "repos",
    foreignKeys = [ForeignKey(
        entity = RoomGithubUser::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RoomGithubUserRepos(
    @PrimaryKey
    val id: Long,
    val name: String,
    val forksCount: Int,
    var userId: Long? = null
)
