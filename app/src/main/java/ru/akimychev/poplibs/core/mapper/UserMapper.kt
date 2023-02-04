package ru.akimychev.poplibs.core.mapper

import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.Repo
import ru.akimychev.poplibs.network.ReposDto
import ru.akimychev.poplibs.network.UserDto

object UserMapper {

    fun mapToEntity(dto: UserDto): GithubUser {
        return GithubUser(
            login = dto.login,
            id = dto.id,
            userAvatar = dto.avatarUrl,
        )
    }
}