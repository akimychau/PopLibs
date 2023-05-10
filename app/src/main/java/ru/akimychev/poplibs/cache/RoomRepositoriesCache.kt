package ru.akimychev.poplibs.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.core.mapper.RepoMapper
import ru.akimychev.poplibs.database.GithubAppDb
import ru.akimychev.poplibs.database.RoomGithubUserRepos
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.GithubUserRepos
import ru.akimychev.poplibs.network.GithubUserReposDto

class RoomRepositoriesCache(private val db: GithubAppDb) : IRepositoriesCache {

    override fun insertReposToDb(
        githubUserReposDto: List<GithubUserReposDto>,
        githubUser: GithubUser,
    ): Completable {
        return db.reposDao().insertAll(githubUserReposDto.map { userDto ->
            RoomGithubUserRepos(userDto.id,
                userDto.name,
                userDto.forksCount,
                githubUser.id)
        })
    }

    override fun getReposFromDb(user: GithubUser): Single<List<GithubUserRepos>> {
        return db.reposDao().findForUser(user.id).map { it.map(RepoMapper::mapDbToEntity) }
    }
}