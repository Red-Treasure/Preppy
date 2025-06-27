package org.redtreasure.preppy

import android.app.Application

class PreppyApplication : Application() {
    companion object {
        lateinit var instance: PreppyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}