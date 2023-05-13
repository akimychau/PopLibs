package ru.akimychev.poplibs.di

import dagger.Component
import ru.akimychev.poplibs.details.GithubUserReposPresenter
import ru.akimychev.poplibs.di.modules.*
import ru.akimychev.poplibs.forksCount.ForksCountPresenter
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
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(githubUsersPresenter: GithubUsersPresenter)
    fun inject(githubUserReposPresenter: GithubUserReposPresenter)
    fun inject(forksCountPresenter: ForksCountPresenter)
}