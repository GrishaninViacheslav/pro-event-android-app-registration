package ru.myproevent.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.myproevent.ProEventApp
import ru.myproevent.databinding.FragmentHomeBinding
import ru.myproevent.domain.di.ProEventScreensComponent
import ru.myproevent.ui.BackButtonListener
import ru.myproevent.ui.presenters.home.HomePresenter
import ru.myproevent.ui.presenters.home.HomeView
import ru.myproevent.ui.presenters.main.MainView
import ru.myproevent.ui.presenters.main.Menu
import javax.inject.Inject

class HomeFragment : MvpAppCompatFragment(), HomeView, BackButtonListener {
    private var _view: FragmentHomeBinding? = null
    private val view get() = _view!!

    @Inject
    lateinit var router: Router

    private val presenter: HomePresenter by moxyPresenter {
        HomePresenter(router)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    private var proEventScreensComponent: ProEventScreensComponent? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        proEventScreensComponent =
            (requireActivity().application as? ProEventApp)
                ?.proEventApplicationComponent
                ?.proEventScreensComponent()
                ?.build()
                ?.also { it.inject(this) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as MainView).selectItem(Menu.HOME)
        _view = FragmentHomeBinding.inflate(inflater, container, false)
        return view.root
    }

    override fun backPressed() = presenter.backPressed()

    override fun onDestroyView() {
        super.onDestroyView()
        _view = null
    }
}