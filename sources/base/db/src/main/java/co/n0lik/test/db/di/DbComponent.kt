package co.n0lik.test.db.di

import dagger.Component
import dagger.Module
import dagger.Provides
import co.n0lik.test.App
import co.n0lik.test.db.DataDatabase
import co.n0lik.test.db.DbDao
import co.n0lik.test.db.DbDaoImpl
import co.n0lik.test.di.MainToolsProvider


interface DatabaseProvider {
    fun provideDao(): DbDao
}

@Component(
        dependencies = [MainToolsProvider::class],
        modules = [DbModule::class]
)
interface DbComponent: DatabaseProvider

@Module
abstract class DbModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideDbDao(app: App): DbDao = DbDaoImpl(DataDatabase.getInstance(app.getApplicationContext())!!)

    }

}