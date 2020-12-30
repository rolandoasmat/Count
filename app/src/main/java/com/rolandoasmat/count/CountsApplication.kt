package com.rolandoasmat.count

import android.app.Application
import com.rolandoasmat.count.di.ApplicationComponent
import com.rolandoasmat.count.di.DaggerApplicationComponent
import com.rolandoasmat.count.di.modules.ContextModule

class CountsApplication: Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(applicationContext))
            .build()
    }

    fun component(): ApplicationComponent {
        return applicationComponent
    }

}