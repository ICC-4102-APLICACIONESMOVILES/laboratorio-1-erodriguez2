package com.example.eduardo.lab1

import android.content.Context

class CredentialsManager(){
    private var email = ""
    private var password = ""
    private lateinit var context: Context

    constructor(newContext: Context) : this() {
        context = newContext
    }

    fun getEmail(): String{
        return email
    }

    fun getPassword(): String{
        return password
    }

    fun setEmail(newEmail: String){
        email = newEmail
    }

    fun setPassword(newPassword: String){
        password = newPassword
    }
}