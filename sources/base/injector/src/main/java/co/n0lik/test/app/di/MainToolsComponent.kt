package co.n0lik.test.app.di

import dagger.BindsInstance
import dagger.Component
import co.n0lik.test.App
import co.n0lik.test.di.MainToolsProvider
import javax.inject.Singleton

@Singleton
@Component
interface MainToolsComponent: MainToolsProvider {

    @Component.Builder
    interface Builder {
        fun build(): MainToolsComponent
        @BindsInstance fun app(app: App): Builder
    }

    class Initializer private constructor() {

        companion object {
            fun init(app: App): MainToolsProvider =
                    DaggerMainToolsComponent.builder()
                            .app(app)
                            .build()
        }

    }

}