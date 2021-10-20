package ru.myproevent.domain.di

import dagger.Subcomponent
import ru.myproevent.ui.fragments.AuthorizationFragment
import ru.myproevent.ui.fragments.HomeFragment
import ru.myproevent.ui.fragments.SettingsFragment

@Subcomponent(modules = [GitHubUsersModule::class])
interface GitHubUsersComponent {

    fun inject(authorizationFragment: AuthorizationFragment)
    fun inject(homeFragment: HomeFragment)
    fun inject(settingsFragment: SettingsFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): GitHubUsersComponent

    }

}