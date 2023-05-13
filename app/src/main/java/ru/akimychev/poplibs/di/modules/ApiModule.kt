package ru.akimychev.poplibs.di.modules

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.akimychev.poplibs.App
import ru.akimychev.poplibs.BuildConfig
import ru.akimychev.poplibs.network.connectivityListener.ConnectivityListener
import ru.akimychev.poplibs.network.connectivityListener.INetworkStatus
import ru.akimychev.poplibs.network.IDataSource
import javax.inject.Named
import javax.inject.Singleton


@Module
class ApiModule {

    @Named("baseUrl")
    @Provides
    fun baseUrl(): String = BuildConfig.SERVER_URL

    @Singleton
    @Provides
    fun gson() = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    @Singleton
    @Provides
    fun client() = OkHttpClient.Builder()
        .build()

    @Singleton
    @Provides
    fun api(@Named("baseUrl") baseUrl: String, gson: Gson, client: OkHttpClient): IDataSource =
        Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(IDataSource::class.java)

    @Singleton
    @Provides
    fun networkStatus(app: App): INetworkStatus = ConnectivityListener(app)
}