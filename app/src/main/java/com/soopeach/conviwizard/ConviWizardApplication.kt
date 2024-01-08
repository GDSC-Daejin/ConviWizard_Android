package com.soopeach.conviwizard

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ConviWizardApplication : Application() {
    override fun onCreate() {
        startKoin {

            androidLogger()
            androidContext(this@ConviWizardApplication)

            modules(
                listOf(
                    viewModelModule,
                    useCaseModule,
                    repositoryModule,
                    dataSourceModule,
                    databaseModule,
                    networkModule
                ),
            )
        }

        super.onCreate()
    }
}