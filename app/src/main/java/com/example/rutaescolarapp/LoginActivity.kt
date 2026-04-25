package com.example.rutaescolarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class  LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etRol = findViewById<EditText>(R.id.etRol)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {

            val usuario = etUsuario.text.toString()
            val rol = etRol.text.toString()
            val password = etPassword.text.toString()

            if (usuario == "admin" && rol == "admin" && password == "1234") {

                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
