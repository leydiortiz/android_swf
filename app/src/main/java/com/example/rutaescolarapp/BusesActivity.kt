package com.example.rutaescolarapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BusesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buses)

        // Botones principales
        val btnVolver = findViewById<Button>(R.id.btnVolver)
        val btnBus1 = findViewById<Button>(R.id.btnBus1)
        val btnBus2 = findViewById<Button>(R.id.btnBus2)
        val btnBus3 = findViewById<Button>(R.id.btnBus3)

        // Menú inferior
        val btnMenu = findViewById<Button>(R.id.btnMenu)
        val btnServicios = findViewById<Button>(R.id.btnServicios)

        // Botón volver
        btnVolver.setOnClickListener {
            finish()
        }

        // Navegación a servicios
        btnServicios.setOnClickListener {
            val intent = Intent(this, ServiciosActivity::class.java)
            startActivity(intent)
        }

        // Acciones de rutas
        btnBus1.setOnClickListener {
            Toast.makeText(this, "Ruta 1 seleccionada", Toast.LENGTH_SHORT).show()
        }

        btnBus2.setOnClickListener {
            Toast.makeText(this, "Ruta 2 seleccionada", Toast.LENGTH_SHORT).show()
        }

        btnBus3.setOnClickListener {
            Toast.makeText(this, "Ruta 3 seleccionada", Toast.LENGTH_SHORT).show()
        }

        // Botón menú (volver al menú anterior)
        btnMenu.setOnClickListener {
            finish()
        }
    }
}