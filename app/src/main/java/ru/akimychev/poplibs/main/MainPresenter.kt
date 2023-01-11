package ru.akimychev.poplibs.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.akimychev.poplibs.core.nav.UsersScreen

class MainPresenter(
    private val router: Router,
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }
}