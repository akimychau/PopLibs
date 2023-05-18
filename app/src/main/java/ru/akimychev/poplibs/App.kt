package ru.akimychev.poplibs

import android.app.Application
import ru.akimychev.poplibs.di.AppComponent
import ru.akimychev.poplibs.di.DaggerAppComponent
import ru.akimychev.poplibs.di.modules.AppModule
import ru.akimychev.poplibs.di.repos.ReposSubComponent
import ru.akimychev.poplibs.di.user.UserSubComponent

class App : Application() {

    lateinit var appComponent: AppComponent
        private set

    var userSubComponent: UserSubComponent? = null
        private set

    var reposSubComponent: ReposSubComponent? = null
        private set

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun initUserSubComponent() = appComponent.userSubComponent().also {
        userSubComponent = it
    }

    fun releaseUserSubComponent() {
        userSubComponent = null
    }

    fun initReposSubComponent() = userSubComponent?.reposSubComponent().also {
        reposSubComponent = it
    }

    fun releaseReposSubComponent() {
        reposSubComponent = null
    }
}