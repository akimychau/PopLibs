package ru.akimychev.poplibs.database

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface RoomGithubUserReposDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomGithubUserRepos): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<RoomGithubUserRepos>): Completable

    @Delete
    fun delete(user: RoomGithubUserRepos): Completable

    @Query("SELECT * FROM repos")
    fun getAll(): Single<List<RoomGithubUserRepos>>

    @Query("SELECT * FROM repos WHERE userId = :userId")
    fun findForUser(userId: Long): Single<List<RoomGithubUserRepos>>
}