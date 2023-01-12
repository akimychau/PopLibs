package ru.akimychev.poplibs.details

import ru.akimychev.poplibs.model.GithubUser

interface OnItemClick {
    fun onItemClick(login: GithubUser)
}