package ru.akimychev.poplibs.details

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.Repo

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserDetailsView : MvpView {
    fun showLoading()
    fun hideLoading()
    fun initList(list: List<Repo>)
    fun show(user: GithubUser)
}
