package fr.beapp.lesson.bicloo.shared

class PreferencesManager {
}

expect object PreferenceStorage {
    fun putBoolean(key: String, value: Boolean)
    fun getBoolean(key: String, defaultValue: Boolean): Boolean
}

