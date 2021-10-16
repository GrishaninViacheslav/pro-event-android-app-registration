package ru.myproevent.ui.presenters.main

import moxy.MvpPresenter
import ru.myproevent.App
import ru.myproevent.ui.screens.IScreens
import ru.myproevent.ui.screens.Screens

class MainPresenter() : MvpPresenter<MainView>() {
    var router = App.instance.router

    var screens: IScreens = Screens()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.authorization())
    }

    fun backClicked() {
        router.exit()
    }
}