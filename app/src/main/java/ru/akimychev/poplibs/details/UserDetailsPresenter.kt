package ru.akimychev.poplibs.details

import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.akimychev.poplibs.core.nav.ForksCountScreen
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.GithubUserRepos
import ru.akimychev.poplibs.repository.UserDetailsRepository
import ru.akimychev.poplibs.core.utils.disposeBy
import ru.akimychev.poplibs.core.utils.subscribeByDefault

class UserDetailsPresenter(
    private val router: Router,
    private val userDetailsRepository: UserDetailsRepository
) : MvpPresenter<UserDetailsView>() {

    private val bag = CompositeDisposable()

    fun getLogin(user: GithubUser) {
        viewState.showLoading()
        userDetailsRepository.getRepos(user)
            .subscribeByDefault()
            .subscribe(
                { list ->
                    viewState.show(user)
                    viewState.initList(list)
                    viewState.hideLoading()
                },
                {
                    it.message?.let { it1 -> Log.e("@@@", it1) }
                    println("Что-то пошло не так")
                }
            ).disposeBy(bag)
    }

    fun navigateToDetails(repos: GithubUserRepos) {
        router.navigateTo(ForksCountScreen(repos))
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}


