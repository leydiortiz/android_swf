package com.example.rutaescolarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Botones
        val btnQuienes = findViewById<Button>(R.id.btnQuienes)
        val btnSalir = findViewById<Button>(R.id.btnSalir)
        val btnServicios = findViewById<Button>(R.id.btnServicios)
        val btnBuses = findViewById<Button>(R.id.btnBuses)
        btnServicios.setOnClickListener {
            val intent = Intent(this, ServiciosActivity::class.java)
            startActivity(intent)
        }

        btnBuses.setOnClickListener {
            val intent = Intent(this, BusesActivity::class.java)
            startActivity(intent)
        }
// Acción botón Quiénes somos
        btnQuienes.setOnClickListener {
            val intent = Intent(this, QuienesSomosActivity::class.java)
            startActivity(intent)
        }

// Acción botón salir
        btnSalir.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
