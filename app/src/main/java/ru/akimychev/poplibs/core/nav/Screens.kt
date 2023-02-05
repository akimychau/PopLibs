package ru.akimychev.poplibs.core.nav

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.akimychev.poplibs.details.UserDetailsFragment
import ru.akimychev.poplibs.list.UserListFragment
import ru.akimychev.poplibs.model.GithubUser

object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserListFragment.getInstance()
    }
}

data class UsersDetailsScreen(private val user: GithubUser) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserDetailsFragment.getInstance(user)
    }
}