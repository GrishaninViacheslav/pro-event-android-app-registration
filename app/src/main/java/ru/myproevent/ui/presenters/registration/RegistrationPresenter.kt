package ru.myproevent.ui.presenters.registration

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.myproevent.ui.screens.IScreens
import ru.myproevent.ui.screens.Screens
import javax.inject.Inject

class RegistrationPresenter @Inject constructor(
    private var router: Router,
) : MvpPresenter<RegistrationView>() {
    // TODO: вынести в Dagger
    private var screens: IScreens = Screens()

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}