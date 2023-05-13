package ru.akimychev.poplibs.di.modules

import dagger.Module
import dagger.Provides
import ru.akimychev.poplibs.App

@Module
class AppModule(val app: App) {

    @Provides
    fun app(): App {
        return app
    }
}