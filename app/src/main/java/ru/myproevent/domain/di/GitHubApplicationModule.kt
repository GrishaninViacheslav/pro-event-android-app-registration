package ru.myproevent.domain.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.myproevent.ui.activity.MainActivity

@Module(subcomponents = [GitHubUsersComponent::class])
interface GitHubApplicationModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

}