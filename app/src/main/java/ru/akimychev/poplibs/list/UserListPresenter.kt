package ru.akimychev.poplibs.list

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import ru.akimychev.poplibs.core.nav.UsersDetailsScreen
import ru.akimychev.poplibs.repository.UserListRepository
import ru.akimychev.poplibs.utils.subscribeByDefault
import java.util.concurrent.TimeUnit

class UserListPresenter(
    private val userListRepository: UserListRepository,
    private val router: Router
) : MvpPresenter<UserListView>() {

    private val bag = CompositeDisposable()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        userListRepository.getUsers()
            .delay(2, TimeUnit.SECONDS)
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.initList(it)
                    viewState.hideLoading()
                },
                {
                    println("Что-то пошло не так")
                }
            ).disposeBy(bag)
    }

    private fun Disposable.disposeBy(bag: CompositeDisposable) {
        bag.add(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    fun navigateToDetails(login: String) {
        router.navigateTo(UsersDetailsScreen(login))
    }
}