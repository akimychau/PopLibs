package ru.akimychev.poplibs.details

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.akimychev.poplibs.repository.UserDetailsRepository
import ru.akimychev.poplibs.utils.disposeBy
import ru.akimychev.poplibs.utils.subscribeByDefault

class UserDetailsPresenter(
    private val router: Router,
    private val userDetailsRepository: UserDetailsRepository
) : MvpPresenter<UserDetailsView>() {

    private val bag = CompositeDisposable()

    fun getLogin(login: String) {
        viewState.showLoading()
        userDetailsRepository.getLogin(login)
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.showUserDetails(it)
                    viewState.hideLoading()
                },
                {
                    println("Что-то пошло не так")
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
}


