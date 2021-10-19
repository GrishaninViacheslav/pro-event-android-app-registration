package ru.myproevent.ui.presenters.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.myproevent.App
import ru.myproevent.ui.presenters.authorization.AuthorizationView
import ru.myproevent.ui.screens.IScreens
import ru.myproevent.ui.screens.Screens

class SettingsPresenter(
    // TODO: вынести в Dagger
    private var router: Router = App.instance.router,
    private var screens: IScreens = Screens()
) : MvpPresenter<AuthorizationView>() {
    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}