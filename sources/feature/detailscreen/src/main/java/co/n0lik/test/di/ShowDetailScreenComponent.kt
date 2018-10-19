package co.n0lik.test.di

import dagger.Component
import dagger.Module
import dagger.Provides
import co.n0lik.test.action.ShowDetailScreen
import co.n0lik.test.action.ShowDetailScreenImpl

@Module
class ActionShowDetailScreenModule {
    @Provides
    fun provideShowGithubAction(): ShowDetailScreen = ShowDetailScreenImpl()
}

@Component(
        dependencies = [MainToolsProvider::class],
        modules = [ActionShowDetailScreenModule::class])
interface ActionShowDetailScreenComponent : DetailScreenProvider {
    class Initializer private constructor() {
        companion object {

            fun init(mainToolsProvider: MainToolsProvider): DetailScreenProvider {
                return DaggerActionShowDetailScreenComponent.builder()
                        .mainToolsProvider(mainToolsProvider)
                        .build()
            }

        }
    }
}