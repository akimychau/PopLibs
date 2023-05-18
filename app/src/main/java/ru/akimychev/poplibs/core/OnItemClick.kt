package ru.akimychev.poplibs.core

import ru.akimychev.poplibs.model.entities.GithubUser
import ru.akimychev.poplibs.model.entities.GithubUserRepos

fun interface UserListOnItemClick {
    fun userListOnItemClick(user: GithubUser)
}

fun interface UserDetailsOnItemClick {
    fun userDetailsOnItemClick(repos: GithubUserRepos)
}

