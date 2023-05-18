package ru.akimychev.poplibs.di.user

import dagger.Subcomponent
import ru.akimychev.poplibs.di.repos.ReposSubComponent
import ru.akimychev.poplibs.di.user.module.UserModule
import ru.akimychev.poplibs.presenter.GithubUsersPresenter

@UserScope
@Subcomponent(modules = [UserModule::class])
interface UserSubComponent {
    fun reposSubComponent(): ReposSubComponent

    fun inject(githubUsersPresenter: GithubUsersPresenter)
}