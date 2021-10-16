package ru.myproevent.ui.presenters.authorization

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.myproevent.App

class AuthorizationPresenter(
    // TODO: вынести в Dagger
    private val router: Router = App.instance.router,
) : MvpPresenter<AuthorizationView>() {
    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}