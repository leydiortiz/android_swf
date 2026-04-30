package com.example.rutaescolarapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class BusesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buses)

        // 🔘 Botones principales
        val btnVolver = findViewById<Button>(R.id.btnVolver)
        val btnBus1 = findViewById<Button>(R.id.btnBus1)
        val btnBus2 = findViewById<Button>(R.id.btnBus2)
        val btnBus3 = findViewById<Button>(R.id.btnBus3)

        // 🔻 Menú inferior
        val btnMenu = findViewById<Button>(R.id.btnMenu)
        val btnServicios = findViewById<Button>(R.id.btnServicios)

        // 🔙 BOTÓN VOLVER (regresa a la pantalla anterior)
        btnVolver.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 🔗 IR A SERVICIOS
        btnServicios.setOnClickListener {
            val intent = Intent(this, ServiciosActivity::class.java)
            startActivity(intent)
        }

        // 🔗 IR A MENÚ PRINCIPAL
        btnMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        // 🚌 RUTA 1
        btnBus1.setOnClickListener {
            val intent = Intent(this, MapaActivity::class.java)
            intent.putExtra("latitud", 4.4389)
            intent.putExtra("longitud", -75.2322)
            intent.putExtra("nombreRuta", "Ruta 1 - Centro")
            startActivity(intent)
        }

        // 🚌 RUTA 2
        btnBus2.setOnClickListener {
            val intent = Intent(this, MapaActivity::class.java)
            intent.putExtra("latitud", 4.4497)
            intent.putExtra("longitud", -75.2281)
            intent.putExtra("nombreRuta", "Ruta 2 - Norte")
            startActivity(intent)
        }

        // 🚌 RUTA 3
        btnBus3.setOnClickListener {
            val intent = Intent(this, MapaActivity::class.java)
            intent.putExtra("latitud", 4.4275)
            intent.putExtra("longitud", -75.2376)
            intent.putExtra("nombreRuta", "Ruta 3 - Sur")
            startActivity(intent)
        }
    }
}