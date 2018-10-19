package co.n0lik.test

import android.app.Application
import com.arellomobile.mvp.RegisterMoxyReflectorPackages
import co.n0lik.test.di.ApplicationProvider
import co.n0lik.test.app.di.AppComponent

@RegisterMoxyReflectorPackages("co.n0lik.test.detailscreen", "co.n0lik.test.mainscreen")
class TestApp: Application(), App {

    private val appComponent: AppComponent by lazy { AppComponent.Initializer.init(this@TestApp) }

    override fun getAppComponent(): ApplicationProvider = this.appComponent

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

}