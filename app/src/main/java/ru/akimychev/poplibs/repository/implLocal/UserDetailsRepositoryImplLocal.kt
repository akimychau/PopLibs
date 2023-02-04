package ru.akimychev.poplibs.repository.implLocal

import io.reactivex.rxjava3.core.Single
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.repository.UserDetailsRepository

class UserDetailsRepositoryImplLocal : UserDetailsRepository {

    override fun getLogin(login: String): Single<GithubUser> {
        return Single.create {
            it.onSuccess(GithubUser(login, "id", "userAvatar"))
        }
    }
}