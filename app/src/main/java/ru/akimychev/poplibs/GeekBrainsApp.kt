package ru.akimychev.poplibs

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import ru.akimychev.poplibs.core.utils.ConnectivityListener

class GeekBrainsApp : Application() {

    companion object {
        lateinit var instance: GeekBrainsApp
    }

    private val cicerone: Cicerone<Router> by lazy { Cicerone.create() }

    val navigationHolder = cicerone.getNavigatorHolder()
    val router = cicerone.router

    private lateinit var connectivityListener: ConnectivityListener

    override fun onCreate() {
        super.onCreate()
        instance = this

        connectivityListener = ConnectivityListener(
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        )
    }

    fun getConnectObservable() = connectivityListener.status()
    fun getConnectSingle() = connectivityListener.statusSingle()

}