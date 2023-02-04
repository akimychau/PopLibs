package ru.akimychev.poplibs.details

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.akimychev.poplibs.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserDetailsView : MvpView {
    fun showUserDetails(user: GithubUser)
    fun showLoading()
    fun hideLoading()
}
