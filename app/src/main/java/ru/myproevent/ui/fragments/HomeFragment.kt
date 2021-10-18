package ru.myproevent.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.myproevent.databinding.FragmentHomeBinding
import ru.myproevent.ui.BackButtonListener
import ru.myproevent.ui.presenters.home.HomePresenter
import ru.myproevent.ui.presenters.home.HomeView
import ru.myproevent.ui.presenters.main.MainView

class HomeFragment : MvpAppCompatFragment(), HomeView, BackButtonListener {
    private var _view: FragmentHomeBinding? = null
    private val view get() = _view!!

    private val presenter: HomePresenter by moxyPresenter {
        HomePresenter()
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as MainView).showBottomNavigation()
        _view = FragmentHomeBinding.inflate(inflater, container, false)
        return view.root
    }

    override fun backPressed() = presenter.backPressed()

    override fun onDestroyView() {
        super.onDestroyView()
        _view = null
    }
}