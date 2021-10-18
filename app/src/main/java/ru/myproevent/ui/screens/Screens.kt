package ru.myproevent.ui.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.myproevent.ui.fragments.AuthorizationFragment
import ru.myproevent.ui.fragments.HomeFragment

class Screens : IScreens {
    override fun authorization() = FragmentScreen { AuthorizationFragment.newInstance() }
    override fun home() = FragmentScreen { HomeFragment.newInstance() }
}