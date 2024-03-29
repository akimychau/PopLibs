package ru.akimychev.poplibs.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.core.mapper.UserMapper
import ru.akimychev.poplibs.model.database.GithubAppDb
import ru.akimychev.poplibs.model.entities.GithubUser

class RoomUserCache(private val db: GithubAppDb) : IUserCache {

    override fun insertUsersToDb(githubUser: List<GithubUser>): Completable {
        return db.userDao().insertAll(githubUser.map(UserMapper::mapEntityToDb))
    }

    override fun getUsersFromDb(): Single<List<GithubUser>> {
        return db.userDao().queryForAllUsers().map { it.map(UserMapper::mapDbToEntity) }
    }
}