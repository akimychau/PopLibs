package ru.akimychev.poplibs.repository

import ru.akimychev.poplibs.model.GithubUser

interface GithubRepository {

    fun getUsers(): List<GithubUser>
}