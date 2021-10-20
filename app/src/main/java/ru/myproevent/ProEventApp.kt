package ru.myproevent

import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import ru.myproevent.domain.di.DaggerGitHubApplicationComponent
import ru.myproevent.domain.di.GitHubApplicationComponent

class ProEventApp : DaggerApplication() {
    companion object {
        private var INSTANCE: DaggerApplication? = null
        val instance: DaggerApplication
            get() = INSTANCE!!
    }

    override fun applicationInjector(): AndroidInjector<ProEventApp> =
        gitHubApplicationComponent

    val gitHubApplicationComponent: GitHubApplicationComponent by lazy {
        DaggerGitHubApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()

                withNavigatorHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
            }
            .build()
    }

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
}