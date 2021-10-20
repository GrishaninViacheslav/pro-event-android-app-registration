package ru.myproevent.domain.di

import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import ru.myproevent.ui.presenters.main.MainPresenter
import ru.myproevent.ui.screens.IScreens

@Module
class PresentersModule {
    @Provides
    fun providesFeaturePresenter(
        router: Router,
        screens: IScreens
    ): MainPresenter {
        return MainPresenter(router)
    }
}