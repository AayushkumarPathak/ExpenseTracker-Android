package com.example.expenseTracker.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.expenseTracker.MainActivity
import com.example.expenseTracker.R
import com.google.android.material.textfield.TextInputEditText

class SignupActivity : AppCompatActivity() {

    private lateinit var nameInput: TextInputEditText
    private lateinit var emailInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var confirmPasswordInput: TextInputEditText
    private lateinit var signupButton: Button
    private lateinit var loginPrompt: TextView
    private lateinit var logoImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Initialize views
        logoImage = findViewById(R.id.logoImage)
        nameInput = findViewById(R.id.nameInput)
        emailInput = findViewById(R.id.emailInput)
        passwordInput = findViewById(R.id.passwordInput)
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput)
        signupButton = findViewById(R.id.signupButton)
        loginPrompt = findViewById(R.id.loginPrompt)

        // Load GIF dynamically (same as login)
        Glide.with(this)
            .asGif()
            .load(R.drawable.signup_logo)
            .into(logoImage)

        // Click Listeners
        signupButton.setOnClickListener {
            hideKeyboard()
            if (validateInputs()) {
                performSignup()
            }
        }

        loginPrompt.setOnClickListener {
            hideKeyboard()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    // --- Hide keyboard when tapping outside input fields ---
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            currentFocus!!.clearFocus()
        }
        return super.dispatchTouchEvent(ev)
    }

    private fun hideKeyboard() {
        val view = currentFocus
        view?.let {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    private fun validateInputs(): Boolean {
        val name = nameInput.text.toString().trim()
        val email = emailInput.text.toString().trim()
        val password = passwordInput.text.toString().trim()
        val confirmPassword = confirmPasswordInput.text.toString().trim()

        if (name.isEmpty()) {
            nameInput.error = "Name is required"
            return false
        }

        if (email.isEmpty()) {
            emailInput.error = "Email is required"
            return false
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.error = "Enter a valid email"
            return false
        }

        if (password.isEmpty()) {
            passwordInput.error = "Password is required"
            return false
        }

        if (password.length < 6) {
            passwordInput.error = "Password must be at least 6 characters"
            return false
        }

        if (confirmPassword.isEmpty()) {
            confirmPasswordInput.error = "Please confirm your password"
            return false
        }

        if (password != confirmPassword) {
            confirmPasswordInput.error = "Passwords do not match"
            return false
        }

        return true
    }

    private fun performSignup() {
        val email = emailInput.text.toString().trim()
        val password = passwordInput.text.toString().trim()

        if (AuthManager.registerUser(this, email, password)) {
            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT).show()
        }
    }
}
