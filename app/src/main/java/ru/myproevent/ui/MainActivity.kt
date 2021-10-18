package ru.myproevent.ui

import android.content.Context
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import com.github.terrakok.cicerone.androidx.AppNavigator
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.myproevent.App
import ru.myproevent.R
import ru.myproevent.databinding.ActivityMainBinding
import ru.myproevent.ui.presenters.main.MainPresenter
import ru.myproevent.ui.presenters.main.MainView


class MainActivity : MvpAppCompatActivity(), MainView {
    // TODO: вынести в Dagger
    private val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter {
        MainPresenter()
    }
    private lateinit var view: ActivityMainBinding

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun hideBottomNavigation() {
        if(view.bottomNavigation.visibility == GONE){
            return
        }
        view.bottomNavigation.visibility = GONE
    }

    override fun showBottomNavigation() {
        if(view.bottomNavigation.visibility == VISIBLE){
            return
        }
        view.bottomNavigation.visibility = VISIBLE
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }
}
