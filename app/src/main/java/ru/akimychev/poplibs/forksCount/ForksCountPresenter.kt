package ru.akimychev.poplibs.forksCount

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.akimychev.poplibs.model.UserRepos

class ForksCountPresenter(
    private val router: Router
) : MvpPresenter<ForksCountView>() {

    fun show(repos: UserRepos) {
        viewState.showNumberOfForks(repos.forksCount.toString())
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}