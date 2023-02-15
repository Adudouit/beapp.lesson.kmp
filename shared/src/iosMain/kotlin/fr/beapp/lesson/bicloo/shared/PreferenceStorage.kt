package fr.beapp.lesson.bicloo.shared

import platform.Foundation.NSUserDefaults

actual object PreferenceStorage {

    actual fun putBoolean(key: String, value: Boolean) {
        NSUserDefaults.standardUserDefaults.setBool(value, key)
    }

    actual fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return NSUserDefaults.standardUserDefaults.boolForKey(key)
    }

}