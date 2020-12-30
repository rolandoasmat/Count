package com.rolandoasmat.count.di

import com.rolandoasmat.count.MainActivity
import com.rolandoasmat.count.di.modules.ContextModule
import com.rolandoasmat.count.di.modules.DatabaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ContextModule::class,
    DatabaseModule::class])
interface ApplicationComponent {
    fun inject(app: MainActivity)
}