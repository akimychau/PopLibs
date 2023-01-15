package ru.akimychev.poplibs.list

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.akimychev.poplibs.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserListView : MvpView {

    fun initList(list: List<GithubUser>)
    fun showLoading()
    fun hideLoading()
}