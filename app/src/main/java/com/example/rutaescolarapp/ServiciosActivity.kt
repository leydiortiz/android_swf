package com.example.rutaescolarapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ServiciosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios)

        // Botones principales
        val btnVolver = findViewById<Button>(R.id.btnVolver)
        val btnUbicacion = findViewById<Button>(R.id.btnUbicacion)
        val btnNotificaciones = findViewById<Button>(R.id.btnNotificaciones)
        val btnHorarios = findViewById<Button>(R.id.btnHorarios)
        val btnInfo = findViewById<Button>(R.id.btnInfo)

        // Menú inferior
        val btnMenu = findViewById<Button>(R.id.btnMenu)

        // Botón volver
        btnVolver.setOnClickListener {
            finish()
        }

        // 📍 Abrir mapa
        btnUbicacion.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        // 🔔 Notificaciones
        btnNotificaciones.setOnClickListener {
            Toast.makeText(this, "Notificaciones", Toast.LENGTH_SHORT).show()
        }

        // 📅 Horarios
        btnHorarios.setOnClickListener {
            Toast.makeText(this, "Horarios", Toast.LENGTH_SHORT).show()
        }

        // 👥 Información
        btnInfo.setOnClickListener {
            Toast.makeText(this, "Información", Toast.LENGTH_SHORT).show()
        }

        // 🔙 Menú
        btnMenu.setOnClickListener {
            finish()
        }

        // ℹ️ Servicios (solo si el botón existe en el XML)

    }
}