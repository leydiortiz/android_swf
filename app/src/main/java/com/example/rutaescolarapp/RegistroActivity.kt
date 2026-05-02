package com.example.rutaescolarapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread

class RegistroActivity : AppCompatActivity() {

    private lateinit var etUsuario: EditText
    private lateinit var etRol: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegistrar: Button
    private lateinit var btnVolverLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        etUsuario = findViewById(R.id.etUsuario)
        etRol = findViewById(R.id.etRol)
        etPassword = findViewById(R.id.etPassword)
        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnVolverLogin = findViewById(R.id.btnVolverLogin)

        // 🔥 BOTÓN REGISTRAR (CONECTADO A BD)
        btnRegistrar.setOnClickListener {

            val usuario = etUsuario.text.toString().trim()
            val rol = etRol.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (usuario.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            thread {
                val respuesta = Conexion.registrar(usuario, rol, password)

                runOnUiThread {
                    when (respuesta) {
                        "OK" -> {
                            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
                            finish() // vuelve al login
                        }
                        "EXISTE" -> {
                            Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            Toast.makeText(this, "Error en el registro", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

        // 🔙 VOLVER AL LOGIN
        btnVolverLogin.setOnClickListener {
            finish()
        }
    }
}