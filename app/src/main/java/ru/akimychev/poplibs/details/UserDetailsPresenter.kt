package ru.akimychev.poplibs.details

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.akimychev.poplibs.repository.UserDetailsRepository

class UserDetailsPresenter(
    private val router: Router
) : MvpPresenter<UserDetailsView>(), UserDetailsRepository {

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    override fun getLogin(login: String) {
        viewState.initLogin(login)
    }

}


