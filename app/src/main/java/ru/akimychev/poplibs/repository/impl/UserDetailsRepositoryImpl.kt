package ru.akimychev.poplibs.repository.impl

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.repository.UserDetailsRepository

class UserDetailsRepositoryImpl : UserDetailsRepository {

    override fun getLogin(login: String) {
        Single.create{
            it.onSuccess(String)
        }
    }

}