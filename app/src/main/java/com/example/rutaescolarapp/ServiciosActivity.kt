package com.example.rutaescolarapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ServiciosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios)

        // 🔘 Botones principales
        val btnVolver = findViewById<Button>(R.id.btnVolver)
        val btnUbicacion = findViewById<Button>(R.id.btnUbicacion)
        val btnNotificaciones = findViewById<Button>(R.id.btnNotificaciones)
        val btnHorarios = findViewById<Button>(R.id.btnHorarios)
        val btnInfo = findViewById<Button>(R.id.btnInfo)

        // 🔻 Menú inferior
        val btnMenu = findViewById<Button>(R.id.btnMenu)
        val btnBuses = findViewById<Button>(R.id.btnBuses) // 🔥 ESTE FALTABA

        // 🔙 Volver
        btnVolver.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 📍 Mapa
        btnUbicacion.setOnClickListener {
            startActivity(Intent(this, MapaActivity::class.java))
        }

        // 🔔 Notificaciones
        btnNotificaciones.setOnClickListener {
            startActivity(Intent(this, NotificacionesActivity::class.java))
        }

        // 📅 Horarios
        btnHorarios.setOnClickListener {
            startActivity(Intent(this, HorariosActivity::class.java))
        }

        // 👥 Información
        btnInfo.setOnClickListener {
            startActivity(Intent(this, InfoActivity::class.java))
        }

        // 🚌 BUSES (🔥)
        btnBuses.setOnClickListener {
            startActivity(Intent(this, BusesActivity::class.java))
        }

        // 🔙 Menú
        btnMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}