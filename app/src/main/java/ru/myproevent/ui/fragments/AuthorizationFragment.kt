package ru.myproevent.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.myproevent.App
import ru.myproevent.databinding.FragmentAuthorizationBinding
import ru.myproevent.ui.BackButtonListener
import ru.myproevent.ui.presenters.authorization.AuthorizationPresenter
import ru.myproevent.ui.presenters.authorization.AuthorizationView

class AuthorizationFragment : MvpAppCompatFragment(), AuthorizationView, BackButtonListener {
    private var _view: FragmentAuthorizationBinding? = null
    private val view get() = _view!!

    private val presenter: AuthorizationPresenter by moxyPresenter {
        AuthorizationPresenter()
    }

    companion object {
        fun newInstance() = AuthorizationFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return view.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _view = null
    }

    override fun backPressed() = presenter.backPressed()
}