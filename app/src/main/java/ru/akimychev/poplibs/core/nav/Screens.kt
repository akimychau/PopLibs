package ru.akimychev.poplibs.core.nav

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.akimychev.poplibs.details.UserDetailsFragment
import ru.akimychev.poplibs.list.UserListFragment

object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserListFragment.getInstance()
    }
}

data class UsersDetailsScreen(private val login: String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserDetailsFragment.getInstance(login)
    }
}