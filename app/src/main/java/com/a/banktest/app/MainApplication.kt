package com.a.banktest.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.a.banktest.di.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        // start Koin
        startKoin {
            androidLogger()
            // declare used Android context
            androidContext(this@MainApplication)
            // declare module list
            modules(viewModel)
        }    }
}