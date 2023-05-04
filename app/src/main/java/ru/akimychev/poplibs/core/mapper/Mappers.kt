package ru.akimychev.poplibs.core.mapper

import ru.akimychev.poplibs.database.RoomGithubUser
import ru.akimychev.poplibs.database.RoomGithubUserRepos
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.GithubUserRepos
import ru.akimychev.poplibs.network.GithubUserDto
import ru.akimychev.poplibs.network.GithubUserReposDto

object RepoMapper {
    fun mapDtoToEntity(userDto: GithubUserReposDto): GithubUserRepos {
        return GithubUserRepos(
            name = userDto.name,
            forksCount = userDto.forksCount
        )
    }

    fun mapDbToEntity(repoDb: RoomGithubUserRepos): GithubUserRepos {
        return GithubUserRepos(
            forksCount = repoDb.forksCount,
            name = repoDb.name
        )
    }
}

object UserMapper {
    fun mapDtoToEntity(userDto: GithubUserDto): GithubUser {
        return GithubUser(
            id = userDto.id,
            login = userDto.login,
            avatarUrl = userDto.avatarUrl,
            reposUrl = userDto.reposUrl
        )
    }

    fun mapDbToEntity(userDb: RoomGithubUser): GithubUser {
        return GithubUser(
            id = userDb.id,
            login = userDb.login,
            avatarUrl = userDb.avatarUrl,
            reposUrl = userDb.reposUrl
        )
    }

    fun mapDtoToDb(userDto: GithubUserDto): RoomGithubUser {
        return RoomGithubUser(
            id = userDto.id,
            login = userDto.login,
            avatarUrl = userDto.avatarUrl,
            reposUrl = userDto.reposUrl
        )
    }

}