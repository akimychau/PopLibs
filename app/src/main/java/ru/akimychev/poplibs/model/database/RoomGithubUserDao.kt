package ru.akimychev.poplibs.model.database

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.entities.room.RoomGithubUser

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