package ru.akimychev.poplibs.core.mapper

import ru.akimychev.poplibs.model.entities.room.RoomGithubUser
import ru.akimychev.poplibs.model.entities.room.RoomGithubUserRepos
import ru.akimychev.poplibs.model.entities.GithubUser
import ru.akimychev.poplibs.model.entities.GithubUserRepos

object RepoMapper {

    fun mapDbToEntity(repoDb: RoomGithubUserRepos): GithubUserRepos {
        return GithubUserRepos(
            id = repoDb.id,
            forksCount = repoDb.forksCount,
            name = repoDb.name
        )
    }
}

object UserMapper {

    fun mapDbToEntity(userDb: RoomGithubUser): GithubUser {
        return GithubUser(
            id = userDb.id,
            login = userDb.login,
            avatarUrl = userDb.avatarUrl,
            reposUrl = userDb.reposUrl
        )
    }

    fun mapEntityToDb(user: GithubUser): RoomGithubUser {
        return RoomGithubUser(
            id = user.id,
            login = user.login,
            avatarUrl = user.avatarUrl,
            reposUrl = user.reposUrl
        )
    }
}