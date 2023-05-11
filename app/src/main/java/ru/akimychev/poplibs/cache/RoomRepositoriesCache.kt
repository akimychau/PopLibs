package ru.akimychev.poplibs.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.core.mapper.RepoMapper
import ru.akimychev.poplibs.database.GithubAppDb
import ru.akimychev.poplibs.database.RoomGithubUserRepos
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.GithubUserRepos

class RoomRepositoriesCache(private val db: GithubAppDb) : IRepositoriesCache {

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