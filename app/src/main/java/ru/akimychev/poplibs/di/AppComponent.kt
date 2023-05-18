package ru.akimychev.poplibs.di

import dagger.Component
import ru.akimychev.poplibs.di.modules.ApiModule
import ru.akimychev.poplibs.di.modules.AppModule
import ru.akimychev.poplibs.di.modules.CiceroneModule
import ru.akimychev.poplibs.di.modules.DatabaseModule
import ru.akimychev.poplibs.di.user.UserSubComponent
import ru.akimychev.poplibs.view.main.MainActivity
import ru.akimychev.poplibs.presenter.MainPresenter
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CiceroneModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent {
    fun userSubComponent(): UserSubComponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
}