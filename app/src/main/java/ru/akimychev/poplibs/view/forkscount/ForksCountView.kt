package ru.akimychev.poplibs.view.forkscount

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ForksCountView: MvpView {
    fun showNumberOfForks(forks: String)
}