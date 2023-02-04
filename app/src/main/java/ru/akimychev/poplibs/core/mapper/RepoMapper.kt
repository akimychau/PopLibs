package ru.akimychev.poplibs.core.mapper

import ru.akimychev.poplibs.model.Repo
import ru.akimychev.poplibs.network.ReposDto

object RepoMapper {
    fun mapToEntity2(dto: ReposDto): Repo {
        return Repo(
            name = dto.name
        )
    }
}