package ru.akimychev.poplibs.view.users

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.akimychev.poplibs.model.entities.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface GithubUsersView : MvpView {
    fun initList(list: List<GithubUser>)
    fun showLoading()
    fun hideLoading()
    fun release()
}