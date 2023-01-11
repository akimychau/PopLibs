package ru.akimychev.poplibs.repository.impl

import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.repository.GithubRepository

class GithubRepositoryImpl : GithubRepository {

    private val repositories = listOf(
        GithubUser("Cat"),
        GithubUser("Dog"),
        GithubUser("Mouse"),
        GithubUser("Pig"),
        GithubUser("Rat")
    )

    override fun getUsers(): List<GithubUser> {
        return repositories
    }
}