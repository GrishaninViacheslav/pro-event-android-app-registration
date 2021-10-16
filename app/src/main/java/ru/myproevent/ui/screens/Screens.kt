package ru.myproevent.ui.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.myproevent.ui.fragments.AuthorizationFragment

class Screens : IScreens {
    override fun authorization() = FragmentScreen { AuthorizationFragment.newInstance() }
}