package ru.myproevent

import android.app.Application
import com.github.terrakok.cicerone.Cicerone

class App : Application() {
    // TODO: Вынести в Dagger
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
//        // TODO: Вынести в Dagger
//        CalligraphyConfig.initDefault(
//            CalligraphyConfig.Builder()
//                .setDefaultFontPath(getString(R.string.default_font))
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//        )
    }


    companion object {
        private var INSTANCE: App? = null
        val instance: App
            get() = INSTANCE!!
    }
}