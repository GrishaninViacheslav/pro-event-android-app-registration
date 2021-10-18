package ru.myproevent.ui.presenters.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.myproevent.App
import ru.myproevent.ui.screens.IScreens
import ru.myproevent.ui.screens.Screens

class MainPresenter(
    // TODO: вынести в Dagger
    private var router: Router = App.instance.router,
    private var screens: IScreens = Screens()
) :
    MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.authorization())
    }

    fun backClicked() {
        router.exit()
    }
}