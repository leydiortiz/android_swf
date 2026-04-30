package com.example.rutaescolarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etRol = findViewById<EditText>(R.id.etRol)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnIrRegistro = findViewById<Button>(R.id.btnIrRegistro)

        // 🔐 BOTÓN LOGIN
        btnLogin.setOnClickListener {

            val usuario = etUsuario.text.toString().trim()
            val rol = etRol.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // 🔑 Usuarios permitidos (temporal)
            val loginCorrecto =
                (usuario == "admin" && rol == "admin" && password == "1234") ||
                        (usuario == "juan" && rol == "padre" && password == "1234") ||
                        (usuario == "maria" && rol == "acudiente" && password == "1234")

            if (loginCorrecto) {
                Toast.makeText(this, "Bienvenido $usuario", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        // 🆕 BOTÓN REGISTRARSE
        btnIrRegistro.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }
}