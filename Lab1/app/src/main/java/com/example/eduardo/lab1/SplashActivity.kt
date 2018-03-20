package com.example.eduardo.lab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.anko.find

class SplashActivity : AppCompatActivity() {

    private val splashScreen = 4000
    private lateinit var resultsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        getUIReferences()

        Handler().postDelayed({
            startActivityForResult(Intent(this,MainActivity::class.java), 1)
        },splashScreen.toLong())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        val extras = data.extras
        resultsTextView.text = "Usuario: " + extras.get("userEmail").toString() + " Password: " + extras.get("userPassword").toString()
        resultsTextView.visibility = View.VISIBLE
    }

    private fun getUIReferences(){
        resultsTextView = find(R.id.resultsTextView)
    }
}
