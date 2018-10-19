package co.n0lik.test.mainscreen.di

import dagger.Module
import dagger.Provides
import co.n0lik.test.di.ActivityScope
import co.n0lik.test.repo.LocalRepo
import co.n0lik.test.mainscreen.MainPresenter
import co.n0lik.test.mainscreen.adapter.RecyclerViewAdapter

@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    fun bindsMainPresenter(repo: LocalRepo): MainPresenter = MainPresenter(repo)

    @Provides
    fun provideRecyclerviewAdapter(): RecyclerViewAdapter = RecyclerViewAdapter()

}
