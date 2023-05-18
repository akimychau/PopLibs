package ru.akimychev.poplibs.view.repos

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.akimychev.poplibs.model.entities.GithubUser
import ru.akimychev.poplibs.model.entities.GithubUserRepos

@StateStrategyType(AddToEndSingleStrategy::class)
interface GithubUserReposView : MvpView {
    fun showLoading()
    fun hideLoading()
    fun initList(list: List<GithubUserRepos>, user: GithubUser)
    fun release()
}
