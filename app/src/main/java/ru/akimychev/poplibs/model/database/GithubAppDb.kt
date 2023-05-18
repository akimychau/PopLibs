package ru.akimychev.poplibs.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.akimychev.poplibs.model.entities.room.RoomGithubUser
import ru.akimychev.poplibs.model.entities.room.RoomGithubUserRepos

@Database(
    entities = [RoomGithubUser::class, RoomGithubUserRepos::class],
    version = 1
)
abstract class GithubAppDb : RoomDatabase() {
    abstract fun userDao(): RoomGithubUserDao
    abstract fun reposDao(): RoomGithubUserReposDao

    companion object {
        const val DB_NAME = "github.db"
    }
}