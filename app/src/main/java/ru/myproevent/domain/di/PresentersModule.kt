package ru.myproevent.domain.di

import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import ru.myproevent.ui.presenters.main.MainPresenter

@Module
class PresentersModule {
    @Provides
    fun providesFeaturePresenter(router: Router): MainPresenter {
        return MainPresenter(router)
    }
}