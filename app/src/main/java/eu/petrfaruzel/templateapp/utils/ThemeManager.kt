package eu.petrfaruzel.templateapp.utils

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatDelegate
import eu.petrfaruzel.templateapp.App
import eu.petrfaruzel.templateapp.R


class ThemeManager {

    companion object {

        // Update theme immediately
        fun applyCurrentDayNightScheme(context : Context = App.getContext()){
            when {
                doesThemeFollowOS(context) -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)}
                isNightThemeSelected(context) -> { AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES)
                }
                else -> { AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) }
            }
        }

        fun doesThemeFollowOS(context : Context = App.getContext()) = Prefs(context).settings.doesNightModeFollowOS
        fun isNightThemeSelected(context : Context = App.getContext()) = Prefs(context).settings.isNightMode
        fun isNightThemeActivated(context : Context = App.getContext()) = isNightThemeSelected(context)&& !doesThemeFollowOS(context)

        fun setThemeFollowOS(value : Boolean, context : Context = App.getContext()){
            Prefs(context).settings.doesNightModeFollowOS = value
            applyCurrentDayNightScheme(context)
        }

        fun switchDayNightTheme(context : Context = App.getContext()){
            Prefs(context).settings.isNightMode = !Prefs(context).settings.isNightMode
            applyCurrentDayNightScheme(context)
        }

        fun changeTheme(activity : Activity, @StyleRes styleRes : Int){
            val theme = Theme.resToTheme(styleRes)
            Prefs().settings.theme = theme
            activity.setTheme(theme.styleRes)
            activity.recreate()
        }

        fun applyActiveTheme(activity : Activity){
            activity.setTheme(Prefs().settings.theme.styleRes)
        }

    }

    // TODO (CHANGE + ADD)
    enum class Theme(val id : Int, @StyleRes val styleRes : Int) {
        PrimaryTheme(0, R.style.PrimaryTheme),
        SecondaryTheme(1, R.style.SecondaryTheme);

        companion object{
            private val resMap = values().associateBy(Theme::styleRes)
            fun resToTheme(@StyleRes styleRes : Int) = resMap[styleRes] ?: PrimaryTheme

            private val idMap = values().associateBy(Theme::id)
            fun idToTheme(id : Int) = idMap[id] ?: PrimaryTheme
        }
    }
}