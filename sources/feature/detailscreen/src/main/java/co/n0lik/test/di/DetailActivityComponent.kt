package co.n0lik.test.di

import dagger.Component
import dagger.Module
import dagger.Provides
import co.n0lik.test.detailscreen.DetailActivity
import co.n0lik.test.detailscreen.DetailPresenter

@Component(
        dependencies = [ApplicationProvider::class],
        modules = [DetailActivityModule::class])
interface DetailActivityComponent{

    fun inject(activity: DetailActivity)

    class Initializer private constructor() {
        companion object {
            fun init(
                    applicationProvider: ApplicationProvider
            ): DetailActivityComponent {

                return DaggerDetailActivityComponent.builder()
                        .applicationProvider(applicationProvider)
                        .build()
            }
        }
    }
}
@Module
class DetailActivityModule {

    @Provides
    fun provideDetailPresenter(): DetailPresenter = DetailPresenter()

}