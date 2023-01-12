package ru.akimychev.poplibs.list

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.akimychev.poplibs.core.nav.UsersDetailsScreen
import ru.akimychev.poplibs.repository.UserListRepository

class UserListPresenter(
    private val userListRepository: UserListRepository,
    private val router: Router
) : MvpPresenter<UserListView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(userListRepository.getUsers())
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    fun navigateToDetails(login: String) {
        router.navigateTo(UsersDetailsScreen(login))
    }
}