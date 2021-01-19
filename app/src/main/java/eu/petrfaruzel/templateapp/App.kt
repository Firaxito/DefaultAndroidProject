package eu.petrfaruzel.templateapp

import android.app.Application
import android.content.Context
import eu.petrfaruzel.templateapp.utils.ThemeManager

class App: Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        ThemeManager.applyCurrentDayNightScheme(getContext())
    }

    companion object {
        private lateinit var instance : App

        fun getInstance(): App {
            return instance
        }

        fun getContext() : Context {
            return instance.applicationContext
        }
    }
}