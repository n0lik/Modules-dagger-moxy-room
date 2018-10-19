package co.n0lik.test.di

import co.n0lik.test.App
import co.n0lik.test.action.ShowDetailScreen
import co.n0lik.test.repo.LocalRepo

interface ApplicationProvider :
        MainToolsProvider, RepoProvider, DetailScreenProvider

interface MainToolsProvider {
    fun provideContext(): App
}

interface RepoProvider {
    fun provideLocalRepo(): LocalRepo
}

interface DetailScreenProvider {
    fun provideShowDetailScreen(): ShowDetailScreen
}

