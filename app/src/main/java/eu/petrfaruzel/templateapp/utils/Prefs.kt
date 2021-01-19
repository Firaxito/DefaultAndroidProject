package eu.petrfaruzel.templateapp.utils

import android.content.Context
import android.content.SharedPreferences
import eu.petrfaruzel.templateapp.App


class Prefs(context: Context = App.getContext()) {

    private val prefs = Attributes(context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE))
    val attributes = Attributes(context.getSharedPreferences(ATTRIBUTES_FILENAME, Context.MODE_PRIVATE))
    var settings = Settings(context.getSharedPreferences(SETTINGS_FILENAME, Context.MODE_PRIVATE))


    class Attributes(private var prefs: SharedPreferences){
        // TODO (CHANGE | ADD)
    }

    class Settings(private var prefs: SharedPreferences) {

        private val IS_NIGHT_MODE = "day_night_mode"
        private val NIGHT_MODE_FOLLOW_OS = "night_mode_follow_os"
        private val THEME = "theme"

        var isNightMode: Boolean
            get() = prefs.getBoolean(IS_NIGHT_MODE, false)
            set(value) = prefs.edit().putBoolean(IS_NIGHT_MODE, value).apply()

        var doesNightModeFollowOS: Boolean
            get() = prefs.getBoolean(NIGHT_MODE_FOLLOW_OS, true)
            set(value) = prefs.edit().putBoolean(NIGHT_MODE_FOLLOW_OS, value).apply()

        var theme: ThemeManager.Theme
            get() = ThemeManager.Theme.idToTheme(prefs.getInt(THEME, ThemeManager.Theme.PrimaryTheme.id))
            set(value) = prefs.edit().putInt(THEME, value.id).apply()

    }

    companion object {
        private const val TAG = "Prefs"
        private const val PREFS_FILENAME = "eu.petrfaruzel.bubbledo"
        private const val SETTINGS_FILENAME = "eu.petrfaruzel.bubbledo.settings"
        private const val ATTRIBUTES_FILENAME = "eu.petrfaruzel.bubbledo.attributes"
    }

}
