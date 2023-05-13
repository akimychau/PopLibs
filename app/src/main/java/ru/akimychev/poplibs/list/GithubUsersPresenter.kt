package ru.akimychev.poplibs.list

import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.akimychev.poplibs.core.nav.UsersDetailsScreen
import ru.akimychev.poplibs.core.utils.disposeBy
import ru.akimychev.poplibs.core.utils.subscribeByDefault
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.repository.IGithubUsersRepository
import javax.inject.Inject

class GithubUsersPresenter : MvpPresenter<GithubUsersView>() {

    @Inject
    lateinit var usersRepository: IGithubUsersRepository
    @Inject
    lateinit var router: Router

    private val bag = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        usersRepository.getUsers()
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.initList(it)
                    viewState.hideLoading()
                },
                {
                    println("Что-то пошло не так")
                    it.message?.let { it1 -> Log.e("@@@", it1) }
                }
            ).disposeBy(bag)
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    fun navigateToDetails(user: GithubUser) {
        router.navigateTo(UsersDetailsScreen(user))
    }
}