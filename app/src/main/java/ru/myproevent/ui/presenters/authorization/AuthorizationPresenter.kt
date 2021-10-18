package ru.myproevent.ui.presenters.authorization

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.myproevent.App
import ru.myproevent.ui.screens.IScreens
import ru.myproevent.ui.screens.Screens

class AuthorizationPresenter(
    // TODO: вынести в Dagger
    private var router: Router = App.instance.router,
    private var screens: IScreens = Screens()
) : MvpPresenter<AuthorizationView>() {

    var tries = 0

    fun authorize(login: String, password: String) {
        fun repositoryGetKey(login: String, password: String): String? {
            return if (tries > 1) {
                "apikey"
            } else {
                tries++
                null
            }
        }
        repositoryGetKey(login, password)?.let {
            router.replaceScreen(screens.home())
        } ?: run { viewState.authorizationDataInvalid() }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}