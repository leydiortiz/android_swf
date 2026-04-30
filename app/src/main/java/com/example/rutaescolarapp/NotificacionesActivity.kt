package com.example.rutaescolarapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NotificacionesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificaciones)

        // 🔙 Flecha en la barra superior
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 🔘 Botón volver en pantalla
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnVolver.setOnClickListener {
            finish()
        }
    }

    // 🔙 Acción de la flecha
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}