package ru.akimychev.poplibs.database

import androidx.room.Database
import androidx.room.RoomDatabase

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