package fr.beapp.lesson.bicloo.shared

import android.content.Context
import android.content.SharedPreferences

actual object PreferenceStorage {
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences("bicloo_preferences", Context.MODE_PRIVATE)
    }

    actual fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit()
            .putBoolean(key, value)
            .apply()
    }

    actual fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

}