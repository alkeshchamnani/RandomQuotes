package com.alkesh.randomquote.common.base

import com.alkesh.randomquote.common.di.DaggerAppComponent
import com.alkesh.randomquote.core.db.DbInstance
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        
        DbInstance.initDatabase(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}