package ru.akimychev.poplibs.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.core.mapper.UserMapper
import ru.akimychev.poplibs.database.GithubAppDb
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.network.GithubUserDto

class RoomUserCache(private val db: GithubAppDb) : IUserCache {

    override fun insertUsersToDb(githubUserDto: List<GithubUserDto>): Completable {
        return db.userDao().insertAll(githubUserDto.map(UserMapper::mapDtoToDb))
    }

    override fun getUsersFromDb(): Single<List<GithubUser>> {
        return db.userDao().queryForAllUsers().map { it.map(UserMapper::mapDbToEntity) }
    }
}