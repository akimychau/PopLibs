package ru.akimychev.poplibs.details

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.akimychev.poplibs.repository.UserDetailsRepository

class UserDetailsPresenter(
    private val userDetailsRepository: UserDetailsRepository,
    private val router: Router
) : MvpPresenter<UserDetailsView>() {

    fun loginClick() {
        val login = "i dont know"
        viewState.initLogin(login)
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

}


