package com.example.eduardo.lab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.anko.find

class SplashActivity : AppCompatActivity() {

    private val DEFAULT_VALUE = ""
    private lateinit var credentialsManager: CredentialsManager
    private lateinit var resultsTextView: TextView
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var signOutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        getUIReferences()
        setupListeners()
        credentialsManager = CredentialsManager(this)

        email = credentialsManager.getEmail()
        password = credentialsManager.getPassword()

        if(email == DEFAULT_VALUE && password == DEFAULT_VALUE){
            startActivityForResult(Intent(this,MainActivity::class.java), 1)
        }
        else{
            showInfo(email, password)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        val extras = data.extras
        val email = extras.get("userEmail").toString()
        val password = extras.get("userPassword").toString()
        saveInfo(email, password)
        showInfo(email, password)
    }

    private fun getUIReferences(){
        resultsTextView = find(R.id.resultsTextView)
        signOutButton = find(R.id.signOutButton)
    }

    private fun setupListeners(){
        signOutButton.setOnClickListener{
            credentialsManager.setEmail(DEFAULT_VALUE)
            credentialsManager.setPassword(DEFAULT_VALUE)
            Toast.makeText(this, "Sesion finalizada", Toast.LENGTH_SHORT).show()
            startActivityForResult(Intent(this,MainActivity::class.java), 1)
        }
    }

    private fun saveInfo(userEmail: String, userPassword: String){
        credentialsManager.setEmail(userEmail)
        credentialsManager.setPassword(userPassword)
    }

    private fun showInfo(userEmail: String, userPassword: String){
        resultsTextView.text = "Usuario: " + userEmail + " Password: " + userPassword
        resultsTextView.visibility = View.VISIBLE
    }
}
