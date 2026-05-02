package com.example.rutaescolarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.concurrent.thread

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
            val password = etPassword.text.toString().trim()

            if (usuario.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 🔥 LLAMADA A BASE DE DATOS
            thread {

                val respuesta = Conexion.login(usuario, password)

                runOnUiThread {

                    if (respuesta.contains("OK")) {
                        Toast.makeText(this, "Bienvenido $usuario", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, MenuActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        // 🆕 BOTÓN REGISTRARSE
        btnIrRegistro.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }
}