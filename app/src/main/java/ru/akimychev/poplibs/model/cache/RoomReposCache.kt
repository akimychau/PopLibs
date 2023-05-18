package ru.akimychev.poplibs.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.core.mapper.RepoMapper
import ru.akimychev.poplibs.model.database.GithubAppDb
import ru.akimychev.poplibs.model.entities.room.RoomGithubUserRepos
import ru.akimychev.poplibs.model.entities.GithubUser
import ru.akimychev.poplibs.model.entities.GithubUserRepos

class RoomReposCache(private val db: GithubAppDb) : IReposCache {

    override fun insertReposToDb(
        githubUserRepos: List<GithubUserRepos>,
        githubUser: GithubUser,
    ): Completable {
        return db.reposDao().insertAll(githubUserRepos.map { user ->
            RoomGithubUserRepos(user.id,
                user.name,
                user.forksCount,
                githubUser.id)
        })
    }

    override fun getReposFromDb(user: GithubUser): Single<List<GithubUserRepos>> {
        return db.reposDao().findForUser(user.id).map { it.map(RepoMapper::mapDbToEntity) }
    }
}