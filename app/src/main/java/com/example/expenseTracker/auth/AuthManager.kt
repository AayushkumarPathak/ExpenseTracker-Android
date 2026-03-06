package com.example.expenseTracker.auth

import android.content.Context
import android.content.SharedPreferences
import android.util.Patterns
import com.google.firebase.auth.FirebaseAuth

object AuthManager {

    private const val PREF_NAME = "auth_prefs"
    private const val KEY_EMAIL = "email"
    private const val KEY_PASSWORD = "password"
    private const val KEY_IS_LOGGED_IN = "is_logged_in"

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance();

    fun registerUser(context: Context, email: String, password: String): Boolean {
        if (!isValidEmail(email) || !isValidPassword(password)) {
            return false
        }

        return true
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun isLoggedIn(context: Context): Boolean {
        return getPrefs(context).getBoolean(KEY_IS_LOGGED_IN, false)
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }

} 