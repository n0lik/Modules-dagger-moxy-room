package co.n0lik.test.repository.di

import dagger.Component
import co.n0lik.test.di.RepoProvider
import co.n0lik.test.di.MainToolsProvider
import co.n0lik.test.db.di.DaggerDbComponent
import co.n0lik.test.db.di.DatabaseProvider

@Component(
        dependencies = [MainToolsProvider::class, DatabaseProvider::class],
        modules = [RepoModule::class])
interface RepoComponent: RepoProvider {

    class Initializer private constructor() {
        companion object {

            fun init(mainToolsProvider: MainToolsProvider): RepoProvider {

                val dbProvider = DaggerDbComponent.builder()
                        .mainToolsProvider(mainToolsProvider)
                        .build()

                return DaggerRepoComponent.builder()
                        .mainToolsProvider(mainToolsProvider)
                        .databaseProvider(dbProvider)
                        .build()
            }
        }
    }

}