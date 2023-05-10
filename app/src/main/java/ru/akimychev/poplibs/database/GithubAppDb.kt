package ru.akimychev.poplibs.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [RoomGithubUser::class, RoomGithubUserRepos::class],
    version = 1
)
abstract class GithubAppDb : RoomDatabase() {
    abstract fun userDao(): RoomGithubUserDao
    abstract fun reposDao(): RoomGithubUserReposDao

    companion object {
        private const val DB_NAME = "github.db"
        private var instance: GithubAppDb? = null

        fun getInstance() = instance ?: throw RuntimeException("Database wasn't created")

        fun create(context: Context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context, GithubAppDb::class.java, DB_NAME).build()
            }
        }
    }
}