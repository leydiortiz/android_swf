package com.example.rutaescolarapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {

    private lateinit var etUsuario: EditText
    private lateinit var etRol: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegistrar: Button
    private lateinit var btnVolverLogin: Button
    private lateinit var tvUsuarios: TextView
   companion object {
        // 🔥 Lista temporal de usuarios (usuario, rol, password)
        val usuariosRegistrados = mutableListOf<Triple<String, String, String>>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        etUsuario = findViewById(R.id.etUsuario)
        etRol = findViewById(R.id.etRol)
        etPassword = findViewById(R.id.etPassword)
        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnVolverLogin = findViewById(R.id.btnVolverLogin)
        tvUsuarios = findViewById(R.id.tvUsuarios)

        // Mostrar usuarios existentes
        mostrarUsuarios()

        btnRegistrar.setOnClickListener {

            val usuario = etUsuario.text.toString().trim()
            val rol = etRol.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (usuario.isEmpty() || rol.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {

                val existe = usuariosRegistrados.any { it.first == usuario }

                if (existe) {
                    Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show()
                } else {

                    usuariosRegistrados.add(Triple(usuario, rol, password))

                    Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()

                    mostrarUsuarios()

                    etUsuario.text.clear()
                    etRol.text.clear()
                    etPassword.text.clear()
                }
            }
        }

        // 🔙 VOLVER AL LOGIN
        btnVolverLogin.setOnClickListener {
            finish()
        }
    }

    private fun mostrarUsuarios() {
        if (usuariosRegistrados.isEmpty()) {
            tvUsuarios.text = "No hay usuarios registrados"
        } else {
            val texto = StringBuilder()

            for (user in usuariosRegistrados) {
                texto.append("Usuario: ${user.first} | Rol: ${user.second}\n")
            }

            tvUsuarios.text = texto.toString()
        }
    }
}