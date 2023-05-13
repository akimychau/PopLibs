package ru.akimychev.poplibs

import android.app.Application
import ru.akimychev.poplibs.di.AppComponent
import ru.akimychev.poplibs.di.DaggerAppComponent
import ru.akimychev.poplibs.di.modules.AppModule

class App : Application() {

    lateinit var appComponent: AppComponent

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
}