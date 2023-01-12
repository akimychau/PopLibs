package ru.akimychev.poplibs.repository

import ru.akimychev.poplibs.model.GithubUser

fun interface UserListRepository {

    fun getUsers(): List<GithubUser>
}

fun interface UserDetailsRepository{
    fun getLogin()
}