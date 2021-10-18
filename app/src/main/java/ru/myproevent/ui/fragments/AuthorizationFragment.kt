package ru.myproevent.ui.fragments

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.myproevent.R
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
        _view = FragmentAuthorizationBinding.inflate(inflater, container, false).apply {
            authorizationConfirm.setOnClickListener {
                presenter.authorize(emailEdit.text.toString(), passwordEdit.text.toString())
            }
            emailInput.errorIconDrawable = null
            passwordInput.errorIconDrawable = null
        }
        return view.root
    }

    private var flag = true

    override fun authorizationDataInvalid() {
        with(view) {
//            emailInput.boxStrokeColor = requireContext().getColor(R.color.PE_bright_red)
//            passwordInput.boxStrokeColor = requireContext().getColor(R.color.PE_bright_red)

            flag = if (flag) {
                val colorState = ColorStateList(
                    arrayOf(intArrayOf(android.R.attr.state_active),
                        intArrayOf( android.R.attr.state_focused),
                        intArrayOf( -android.R.attr.state_focused),
                        intArrayOf( android.R.attr.state_hovered),
                        intArrayOf( android.R.attr.state_enabled),
                        intArrayOf(- android.R.attr.state_enabled)),
                    intArrayOf(
                        requireContext().getColor(R.color.PE_bright_red),
                        requireContext().getColor(R.color.PE_blue_gray_03),
                        requireContext().getColor(R.color.PE_blue_gray_03),
                        requireContext().getColor(R.color.PE_bright_red),
                        requireContext().getColor(R.color.PE_bright_red),
                        requireContext().getColor(R.color.PE_bright_red))
                )
                emailInput.setBoxStrokeColorStateList(colorState)
                passwordInput.error = getString(R.string.authorization_data_invalid)
                false
            } else {
                passwordInput.isErrorEnabled = false
                true
            }
        }
    }

    override fun backPressed() = presenter.backPressed()

    override fun onDestroyView() {
        super.onDestroyView()
        _view = null
    }
}