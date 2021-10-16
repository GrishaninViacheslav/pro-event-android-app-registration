package ru.myproevent

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

class App : Application() {
    // TODO: Вынести в Dagger
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        // TODO: Вынести в Dagger
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath(getString(R.string.default_font))
                            .setFontAttrId(R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )
    }


    companion object {
        private var INSTANCE: App? = null
        val instance: App
            get() = INSTANCE!!
    }
}