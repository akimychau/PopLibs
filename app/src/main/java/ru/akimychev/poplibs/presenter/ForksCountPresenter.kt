package ru.akimychev.poplibs.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.akimychev.poplibs.view.forkscount.ForksCountView
import ru.akimychev.poplibs.model.entities.GithubUserRepos
import javax.inject.Inject

class ForksCountPresenter : MvpPresenter<ForksCountView>() {

    @Inject
    lateinit var router: Router

    fun show(repos: GithubUserRepos) {
        viewState.showNumberOfForks(repos.forksCount.toString())
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}