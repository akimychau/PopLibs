package ru.akimychev.poplibs.di.repos

import dagger.Subcomponent
import ru.akimychev.poplibs.presenter.GithubUserReposPresenter
import ru.akimychev.poplibs.di.repos.module.ReposModule
import ru.akimychev.poplibs.presenter.ForksCountPresenter

@ReposScope
@Subcomponent(modules = [ReposModule::class])
interface ReposSubComponent {
    fun inject(githubUserReposPresenter: GithubUserReposPresenter)
    fun inject(forksCountPresenter: ForksCountPresenter)
}