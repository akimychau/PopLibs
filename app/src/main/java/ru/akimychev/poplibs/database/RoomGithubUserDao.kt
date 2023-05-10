package ru.akimychev.poplibs.database

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface RoomGithubUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userDb: RoomGithubUser): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(usersDb: List<RoomGithubUser>): Completable

    @Delete
    fun delete(userDb: RoomGithubUser): Completable

    @Query("SELECT * FROM users")
    fun queryForAllUsers(): Single<List<RoomGithubUser>>

    @Query("SELECT * FROM users WHERE login = :login LIMIT 1")
    fun findByLogin(login: String): Single<RoomGithubUser>
}