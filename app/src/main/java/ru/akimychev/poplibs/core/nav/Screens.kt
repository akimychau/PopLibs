package ru.akimychev.poplibs.core.nav

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.akimychev.poplibs.details.GithubUserReposFragment
import ru.akimychev.poplibs.forksCount.ForksCountFragment
import ru.akimychev.poplibs.list.GithubUsersFragment
import ru.akimychev.poplibs.model.GithubUser
import ru.akimychev.poplibs.model.GithubUserRepos

object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return GithubUsersFragment.getInstance()
    }
}

data class UsersDetailsScreen(private val user: GithubUser) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return GithubUserReposFragment.getInstance(user)
    }
}

data class ForksCountScreen(private val repos: GithubUserRepos) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return ForksCountFragment.getInstance(repos)
    }
}