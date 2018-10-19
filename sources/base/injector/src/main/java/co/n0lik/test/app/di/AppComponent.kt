package co.n0lik.test.app.di

import dagger.Component
import co.n0lik.test.TestApp
import co.n0lik.test.di.*
import co.n0lik.test.repository.di.RepoComponent
import javax.inject.Singleton

@Component(dependencies = [MainToolsProvider::class, RepoProvider::class, DetailScreenProvider::class])

@Singleton
interface AppComponent: ApplicationProvider {

    fun inject(app: TestApp)

    class Initializer private constructor() {
        companion object {

            fun init(app: TestApp): AppComponent {

                val mainToolsProvider = MainToolsComponent.Initializer.init(app)

                val repoProvider = RepoComponent.Initializer
                        .init(mainToolsProvider)

                val detailProvider = ActionShowDetailScreenComponent.Initializer
                        .init(mainToolsProvider)

                return DaggerAppComponent.builder()
                        .mainToolsProvider(mainToolsProvider)
                        .repoProvider(repoProvider)
                        .detailScreenProvider(detailProvider)
                        .build()

            }
        }
    }

}