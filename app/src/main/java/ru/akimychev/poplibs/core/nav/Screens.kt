package ru.akimychev.poplibs.core.nav

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.akimychev.poplibs.user.UserFragment

object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }

}