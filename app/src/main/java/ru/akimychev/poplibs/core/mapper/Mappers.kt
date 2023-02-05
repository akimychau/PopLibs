package ru.akimychev.poplibs.core.mapper

import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.UserRepos
import ru.akimychev.poplibs.network.UserReposDto
import ru.akimychev.poplibs.network.UserDto

object RepoMapper {
    fun mapToEntity(dto: UserReposDto): UserRepos {
        return UserRepos(
            name = dto.name
        )
    }
}

object UserMapper {
    fun mapToEntity(dto: UserDto): GithubUser {
        return GithubUser(
            login = dto.login,
            id = dto.id,
            userAvatar = dto.avatarUrl,
            reposUrl = dto.reposUrl
        )
    }
}