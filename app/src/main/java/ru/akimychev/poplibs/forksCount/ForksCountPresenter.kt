package ru.akimychev.poplibs.forksCount

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.akimychev.poplibs.model.GithubUserRepos

class ForksCountPresenter(
    private val router: Router
) : MvpPresenter<ForksCountView>() {

    fun show(repos: GithubUserRepos) {
        viewState.showNumberOfForks(repos.forksCount.toString())
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}