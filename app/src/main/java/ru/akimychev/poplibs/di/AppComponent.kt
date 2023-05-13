package ru.akimychev.poplibs.di

import dagger.Component
import ru.akimychev.poplibs.details.GithubUserReposFragment
import ru.akimychev.poplibs.details.GithubUserReposPresenter
import ru.akimychev.poplibs.di.modules.*
import ru.akimychev.poplibs.forksCount.ForksCountFragment
import ru.akimychev.poplibs.forksCount.ForksCountPresenter
import ru.akimychev.poplibs.list.GithubUsersFragment
import ru.akimychev.poplibs.list.GithubUsersPresenter
import ru.akimychev.poplibs.main.MainActivity
import ru.akimychev.poplibs.main.MainPresenter
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CiceroneModule::class,
        DatabaseModule::class,
        RepositoriesModule::class
    ]
)
interface AppComponent{
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)

    fun inject(githubUsersPresenter: GithubUsersPresenter)
    fun inject(githubUsersFragment: GithubUsersFragment)

    fun inject(githubUserReposPresenter: GithubUserReposPresenter)
    fun inject(githubUserReposFragment: GithubUserReposFragment)

    fun inject(forksCountPresenter: ForksCountPresenter)
    fun inject(forksCountFragment: ForksCountFragment)
}