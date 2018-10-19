package co.n0lik.test.mainscreen.di

import dagger.Component
import co.n0lik.test.di.ActivityScope
import co.n0lik.test.di.ApplicationProvider
import co.n0lik.test.mainscreen.MainActivity

@ActivityScope
@Component(
        dependencies = [ApplicationProvider::class],
        modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun inject(activity: MainActivity)

    class Initializer private constructor() {
        companion object {
            fun init(
                    applicationProvider: ApplicationProvider
            ): MainActivityComponent {

                return DaggerMainActivityComponent.builder()
                        .applicationProvider(applicationProvider)
                        .build()
            }
        }
    }
}