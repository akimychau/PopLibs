package ru.akimychev.poplibs.core

import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.UserRepos

fun interface UserListOnItemClick {
    fun userListOnItemClick(user: GithubUser)
}

fun interface UserDetailsOnItemClick {
    fun userDetailsOnItemClick(repos: UserRepos)
}

