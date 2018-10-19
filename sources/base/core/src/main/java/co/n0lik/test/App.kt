package co.n0lik.test

import android.content.Context
import co.n0lik.test.di.ApplicationProvider

interface App {
    fun getApplicationContext(): Context
    fun getAppComponent(): ApplicationProvider
}