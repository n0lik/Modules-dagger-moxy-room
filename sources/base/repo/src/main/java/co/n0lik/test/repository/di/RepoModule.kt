package co.n0lik.test.repository.di

import dagger.Binds
import dagger.Module
import co.n0lik.test.repo.LocalRepo
import co.n0lik.test.repository.LocalRepoImpl

@Module
interface RepoModule{
    @Binds
    fun bindLocalRepo(repo: LocalRepoImpl): LocalRepo
}